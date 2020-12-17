#------------------------------------------------------------------------------
# Configuration file for jupyter-notebook.
#------------------------------------------------------------------------------
# make sure the hoe is always at jupyter home
c.NotebookApp.notebook_dir = "/home/jupyter"

# The default password is set at juypter_notebook_config.json file to "jupyter"
c.NotebookApp.allow_credentials = True
c.NotebookApp.allow_password_change = True

# Definitely run from remote
c.NotebookApp.allow_remote_access = True

# for safety reason we do run as jupyter user
c.NotebookApp.allow_root = False
