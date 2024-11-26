# Time Table Scheduling System

Done by : 
 - Rutwik S (23BCS112)
 - Maddila Rajesh (23BCS077)
 - Shouvik Das (23BCS125)
 - Siddhaartha B S (23BCS127)

## Features

- Input is taken from `*.csv` files found in the `inputFiles/` folder.
- Schedules the classes for 1.5 hours at a time.
- Schedules the tutorials for 1 hours at a time.
- Schedules the practicals for 2 hours at a time.
- All classes follow the LTPSC structure.
- Makes sure that there, not more than 1 class is of 1 lecturer is scheduled for a class in a day.
- Teacher Conflict is checked.
- The output is in a neat formatted `.png` file. (found in `timeTable/` folder) 
 
## How to Execute

### Method 1 : Using Eclipse IDE (preferred method)

1. Unzip the project to any folder
1. Open Eclipse IDE (Installer link [Eclipse IDE for Java Developers](https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2024-09/R/eclipse-java-2024-09-R-win32-x86_64.zip))
![Eclipse IDE](assets/readmeImages/Screenshot (1).png)
![Restore the File Viewer](assets/readmeImages/Screenshot (2).png)
1. Navigate to `File -> Import...`
![Import](assets/readmeImages/Screenshot (3).png)
1. Click on `General -> Existing Projects into Workspace`
![Import2](assets/readmeImages/Screenshot (4).png)
1. Select the root directory where the unzipped file is by clicking on `Browse`
![Opend Unzipped folder](assets/readmeImages/Screenshot (5).png)
1. Under Projects dialogu box, make sure that `timeTableSchedulinev2` is selected.
![Opend Unzipped folder](assets/readmeImages/Screenshot (5).png)
1. Click on finish
![Opend Unzipped folder](assets/readmeImages/Screenshot (6).png)
1. In the left `Package Explorer`, the project will apprear
![package Explorer](assets/readmeImages/Screenshot (7).png)
1. Navigate to the `Main.java` file. (`src/main/java/timeTableSchedulinev2/Main.java`)
![package Explorer](assets/readmeImages/Screenshot (8).png)
1. Click on the green *Run* button (Run the `Main.java` file).
![package Explorer](assets/readmeImages/Screenshot (10).png)
1. The output is printed in the console and it will also be present in the `timeTable/` folder in the root project directory.
![package Explorer](assets/readmeImages/Screenshot (11).png)

### Method 2 : Using maven which has been manually installed (Not preferred)

1. Install maven
    - [How to install Maven on windows?](https://medium.com/@gauravshah97/how-to-install-maven-on-windows-39ff317e40cf)
    - On linux (Ubuntu based systems), run `sudo apt install maven`
1. Open the project folder
1. Run `make build` and `make run`


## Input

- Files are at `inputFiles/` folder.
- The file names should not be changed.
- Each file follows the Semester, Sl.No, Course code, Course name, Credits, L-T-P-S-C, Faculty format and must not be changed.

## General Errors

1. Eclipse warns that there are errors in the code before running. This generally happens because the Maven Dependencies are not yet downloaded. Wait for a few seconds before trying again. Pleas make sure to have an internet connection throught the process.
1. In case this still presists, Click on `Project -> Update Maven Project -> OK`. This should fix all issues.