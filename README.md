Following are the high level scenarios to be tested for problem in hand. These are not automated as of now.
1. Successful Login 
2. Un successful Login 
3. New Folder creation activity 
    1. Creating a new folder 
    2. Renaming a new folder 
    3. Deleting folder
4. File Upload related scenarios 
    1. File upload in root folder 
    2. File upload in new folder created 
    3. Deleting the uploaded file 

Scenario automated is — User,after successful,login creates a new folder and upload 2 files in that folder. 

Limitations 
1. This works only for MAC and for chrome browser as of now.
2. Version of chrome browser (v78) 
3. Site used is https://www.4shared.com

Prerequisite for running the test 
1. Maven and Java are installed

How to run the test 
1. Clone the repo 
2. In project directory run 
    1. mvn clean 
    2. mvn test

