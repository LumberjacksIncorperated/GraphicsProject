#!/bin/sh

#----------------------------------------------------------------------------------------------------------------------
#
# PROJECT
# -------
# Graphics Project
#
# AUTHOR
# ------
# Lumberjacks Incorperated (2018)
#
#----------------------------------------------------------------------------------------------------------------------

#----------------------------------------------------------------------------------------------------------------------
# MAIN
#----------------------------------------------------------------------------------------------------------------------
main()
{
    echo "<START>"
    
    echo "Enter execution starting directory"
    enterExecutionStartingDirectory
    
    echo "execute Project"
    executeProject
    
    echo "<DONE>"
}

#----------------------------------------------------------------------------------------------------------------------
# INTERNAL FUNCTIONS
#----------------------------------------------------------------------------------------------------------------------
function enterExecutionStartingDirectory()
{
    cd ../class_files/
}

function executeProject()
{
    LIBRARY_PATH="lib/jogamp-all-platforms/lib"
    COMPILED_FILE_DIRECTORY="."
    CLASS_PATH="lib/jogamp-all-platforms/jar/gluegen-rt.jar:lib/jogamp-all-platforms/jar/jogl-all.jar:"$COMPILED_FILE_DIRECTORY""
    java -cp "$CLASS_PATH" -Djava.library.path="$LIBRARY_PATH" GraphicsApplication
}

#----------------------------------------------------------------------------------------------------------------------
# SCRIPT
#----------------------------------------------------------------------------------------------------------------------
    main
