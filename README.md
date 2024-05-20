# CucumberQA
# Jenkins Pipeline Script

## Overview

The pipeline is defined using the `pipeline` block, indicating the start of the pipeline script. It is configured to run on any available agent (`agent any`), meaning it can run on any available executor.

## Poll SCM

Poll SCM is a Jenkins feature that checks the source code repository at specified intervals to see if there have been any changes. If changes are detected, a new build is triggered. This is useful for integrating continuous integration practices, ensuring that the latest code changes are automatically built and tested.

## Stages

### Starting
- This stage is named 'Starting'.
- It contains a single step that echoes 'Started pipeline'.

### git
- This stage is named 'git'.
- It contains a single step to checkout the specified branch ('main') from a Git repository hosted at 'https://github.com/YashGupta1510/cucumberQA.git'.

### setup
- This stage is named 'setup'.
- It contains a single step to execute a Windows batch command (`bat`) to clean the project using Maven (`mvn clean`).

### test
- This stage is named 'test'.
- It contains a single step to execute a Windows batch command (`bat`) to run tests using Maven (`mvn test`).

### Building
- This stage is named 'Building'.
- It contains a single step to execute a Windows batch command (`bat`) to clean and build the project using Maven. The `-Dmaven.test.skip=true` flag skips running tests during the build process.

## Post-build Actions

The `post` block defines actions that will be executed after the stages. In this case:
- The `always` block ensures that the specified actions are executed regardless of the pipeline result.
- The `cleanWs()` function cleans the workspace.

