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
    
    echo "Enter compilation starting directory"
    enterCompilationStartingDirectory
    
    echo "Moving java files to main directory for compilation"
    putJavaFilesInMainDirectoryForCompilation
    
    echo "Compile java files"
    compileJavaFiles
    
    echo "Cleanup Project"
    putJavaFilesInJavaFileDirectory
    putClassFilesInClassFileDirectory
    
    echo "<DONE>"
}

#----------------------------------------------------------------------------------------------------------------------
# INTERNAL FUNCTIONS
#----------------------------------------------------------------------------------------------------------------------
function enterCompilationStartingDirectory()
{
    cd ../
}

function putJavaFilesInMainDirectoryForCompilation()
{
    mv ./java_files/*.java ./
}

function compileJavaFiles()
{
    javac -classpath "lib/jogamp-all-platforms/jar/gluegen-rt.jar:lib/jogamp-all-platforms/jar/jogl-all.jar" *.java
}

function putJavaFilesInJavaFileDirectory()
{
    mv ./*.java ./java_files
}

function putClassFilesInClassFileDirectory()
{
    mv ./*.class ./class_files
}


#----------------------------------------------------------------------------------------------------------------------
# SCRIPT
#----------------------------------------------------------------------------------------------------------------------
    main
