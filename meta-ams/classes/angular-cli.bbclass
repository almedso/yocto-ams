inherit npm-base

B="${S}"

DEPENDS += "\
  node-native \
  angular-cli-native \
"

NG ?= "ng"
NG_TASKS ?= "build"
NG_OPTIONS ?= ""

oe_run_angularcli() {
  bbnote ${NG} "$@"
  ${NG} "$@" || die "oe_run_angularcli failed"
}

do_configure() {
  oe_runnpm ${NPM_INSTALL_FLAGS} install

  # install @angular-cli separately.
  # Typically @angular-cli  is a part of
  # devDependencies but in the context of Yocto there is a good
  # chance we might want to avoid other devDependencies but still
  # be able to use @angular-cli.
  oe_runnpm ${NPM_INSTALL_FLAGS} install @angular/cli 
}

do_compile() {
	oe_run_angularcli ${NG_TASKS} ${NG_OPTIONS}
}