node () {

    withEnv([
        'DISTRO=ams',
        'RELEASE=current',
        'YOCTO_VERSION=warrior-next'])
    {

        // Input list images machine comibinations to build
        def machineImages = [
            [ machine: "ricardo", image: "ams-image-minimal", publish: true ],
            [ machine: "ricardo", image: "ams-image", publish: false ],
            [ machine: "ricardo", image: "ams-image-dev", publish: true ],
            [ machine: "ricardo", image: "esp-image", publish: true ],

            [ machine: "rigoletto", image: "ams-image-minimal", publish: true ],
            [ machine: "rigoletto", image: "ams-image", publish: true ],
            [ machine: "rigoletto", image: "ams-image-dev", publish: true ],

            [ machine: "rodolfo", image: "ams-image-minimal", publish: true ],
            [ machine: "rodolfo", image: "ams-image", publish: false ],
            [ machine: "rodolfo", image: "ams-image-dev", publish: true ],
            [ machine: "rodolfo", image: "esp-image", publish: true ],

            [ machine: "ruiz", image: "ams-image-minimal", publish: false ],
            [ machine: "ruiz", image: "ams-image-dev", publish: true ]
        ]
        // End Input

        checkout scm

        def user_id = sh(returnStdout: true, script: 'id -u').trim()
        def group_id = sh(returnStdout: true, script: 'id -g').trim()

        def myImage = docker.image('almedso/yocto-bitbaker:latest')
        myImage.pull()


        myImage.inside("""
            --env YOCTO_VERSION=${YOCTO_VERSION} \
            --env DISTRO=${DISTRO} \
            --volume yocto-cache:/yocto/cache \
            --volume yocto-publish:/yocto/publish \
            --user ${user_id}:${group_id} \
            """
        ) {
            stage('Pull sources') {
                sh 'repo init -u https://github.com/almedso/repo-yocto.git -b ${YOCTO_VERSION}'
                sh 'repo sync'
            }
            stage('Prepare Ennvironment') {
                sh '''#!/bin/bash
                    VOLUME_CACHE_DIR=/yocto/cache
                    export YOCTO_DOWNLOAD_DIR=${VOLUME_CACHE_DIR}/download
                    mkdir -p ${YOCTO_DOWNLOAD_DIR}
                    export YOCTO_SSTATE_DIR=${VOLUME_CACHE_DIR}/sstate/${YOCTO_VERSION}/${DISTRO}
                    mkdir -p ${YOCTO_SSTATE_DIR}
                    export PACKAGE_FEED_BASE_PATHS=${VOLUME_PUBLISH_DIR}/feeds/${YOCTO_VERSION}/${DISTRO}
                    export PACKAGE_FEED_URI="https://yocto.almedso.de"
                    source sources/ams/scripts/ams-init-build-env
                    '''
            }

            machineImages.each{ item ->
                stage("${item.'image'} for ${item.'machine'}") {
                    sh  """#!/bin/bash
                        source sources/ams/scripts/ams-init-build-env
                        MACHINE=${item.'machine'} bitbake ${item.'image'}

                        if [ "${item.'publish'}" = "true" ] ; then
                            mkdir -p /yocto/publish/images/${RELEASE}/${YOCTO_VERSION}/${DISTRO}/
                            cp --dereference tmp-${DISTRO}/deploy/images/${item.'machine'}/${item.'image'}-${item.'machine'}.wic* \
                                /yocto/publish/images/${RELEASE}/${YOCTO_VERSION}/${DISTRO}/
                        fi

                        """
                }
            }

            stage('Publish packages') {
                sh  """#!/bin/bash
                    source sources/ams/scripts/ams-init-build-env
                    bitbake package-index
                    mkdir -p /yocto/publish/feeds/${YOCTO_VERSION}/${DISTRO}/
                    rsync -r -u --exclude 'x86_64*' tmp-${DISTRO}/deploy/ipk/* /yocto/publish/feeds/${YOCTO_VERSION}/${DISTRO}
                    """
            }
        }
    }
}
