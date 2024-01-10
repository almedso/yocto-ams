
RDEPENDS_${PN} += "java2-runtime"


                          S = "${WORKDIR}"
                          OH = "${S}/openhab-runtime"
                          OHaddons = "${S}/openhab-addons"

                          # Add autostart ability
                          inherit autotools update-rc.d
                          INITSCRIPT_NAME = "openhab"
                          INITSCRIPT_PARAMS = "defaults"

                          # Need to rewrite unpack task, since we need the extracted files
                          # in separate folders under WORKDIR.
                          do_unpack[dirs] += "${OH} ${OHaddons}"
                          python do_unpack() {
                              src_uri = (d.getVar('SRC_URI', True) or "").split()

                                  OHdir = d.getVar('OH', True)
                                      OHaddonsdir = d.getVar('OHaddons', True)

                                          try:
                                                  fetcher = bb.fetch2.Fetch([src_uri[0]], d)
                                                          fetcher.unpack(OHdir)
                                                              except bb.fetch2.BBFetchException as e:
                                                                      raise bb.build.FuncFailed(e)

                                                                          try:
                                                                                  fetcher = bb.fetch2.Fetch([src_uri[1]], d)
                                                                                          fetcher.unpack(OHaddonsdir)
                                                                                              except bb.fetch2.BBFetchException as e:
                                                                                                      raise bb.build.FuncFailed(e)

                                                                                                          # Handle any remaining files
                                                                                                              src_uri = src_uri[2:]
                                                                                                                  if len(src_uri) == 0:
                                                                                                                          return

                                                                                                                              rootdir = d.getVar('WORKDIR', True)

                                                                                                                                  try:
                                                                                                                                          fetcher = bb.fetch2.Fetch(src_uri, d)
                                                                                                                                                  fetcher.unpack(rootdir)
                                                                                                                                                      except bb.fetch2.BBFetchException as e:
                                                                                                                                                              raise bb.build.FuncFailed(e)
                                                                                                                                                              }

                                                                                                                                                              do_install() {
                                                                                                                                                                # Simply copy folders to datadir
                                                                                                                                                                    install -d ${D}/${datadir}
                                                                                                                                                                            cp -a ${OH} ${D}/${datadir}
                                                                                                                                                                                    cp -a ${OHaddons} ${D}/${datadir}

                                                                                                                                                                                        # Move desired addons
                                                                                                                                                                                            for addon in ${OPENHAB_ADDONS}
                                                                                                                                                                                                do
                                                                                                                                                                                                        if [ -e "$(find ${OHaddons} -name "*${addon}*")" ]
                                                                                                                                                                                                                then
                                                                                                                                                                                                                            cp $(find ${OHaddons} -name "*${addon}*") ${D}/${datadir}/openhab-runtime/addons
                                                                                                                                                                                                                                    else
                                                                                                                                                                                                                                                bbwarn "openHAB addon cannot be found: ${addon}"
                                                                                                                                                                                                                                                        fi
                                                                                                                                                                                                                                                            done

                                                                                                                                                                                                                                                                # Add init script to allow autostart
                                                                                                                                                                                                                                                                    install -d ${D}/${sysconfdir}/init.d
                                                                                                                                                                                                                                                                        install -m 0755 ${S}/init ${D}/${sysconfdir}/init.d/openhab
                                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                        FILES_${PN} = "${datadir}/openhab-addons ${datadir}/openhab-runtime ${sysconfdir}/init.d/openhab"
