# Java Tools and Path Settings

## javap: The JDK Tool for Class Profiling

The `javap` tool is a part of the JDK and is used to get the profile of a class or interface. It provides details such as:
- List of variables (fields)
- Methods
- Constructors

### Example Usage:
```sh
C:\> javap java.lang.String
```
The above command displays the list of variables, methods, and constructors of the `java.lang.String` class.

---

## Path Settings to Access JDK Tools

### 1. Temporary Path Setting
A temporary path setting applies only to the current command prompt session. Once the session is closed, the setting is lost.

#### Command Example:
```sh
set path="%path%;C:\Program Files\Java\jdk-19\bin"
```

- `C:\Program Files\Java\jdk-19\bin` is the location of the JDK installation.
- The `bin` folder contains JDK tools such as `javac`, `java`, `javap`, etc.

---

### 2. Permanent Path Setting
Setting the path permanently ensures JDK tools are accessible from any command prompt session.

#### Steps to Set a Permanent Path:
1. Open the Windows search bar and type **"Environment Variables"**.
2. Click on **"Edit the system environment variables"**.
3. In the **System Properties** window, click on the **"Environment Variables"** button.
4. Under **User Variables**, locate the `Path` variable:
   - If the `Path` variable already exists:
     - Select the `Path` variable and click on the **"Edit"** button.
     - Click on **"New"**, then enter:
       ```sh
       C:\Program Files\Java\jdk-19\bin
       ```
     - Click **OK** to save changes.
   - If the `Path` variable does not exist:
     - Click **"New"** under **User Variables**.
     - Set the **Variable Name** to `Path` and **Variable Value** to:
       ```sh
       C:\Program Files\Java\jdk-19\bin
       ```
     - Click **OK** to save changes.
5. Click **OK** in all windows to apply changes.
6. Open a new command prompt and verify the setup by typing:
   ```sh
   java -version
   ```
   If the installation is successful, it should display the installed JDK version.


