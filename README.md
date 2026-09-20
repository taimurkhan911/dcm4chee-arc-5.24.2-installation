# dcm4chee-arc-5.24.2 Installation User Manual
This repo is for installation of dcm4che
#### Please follow the follwing steps to install
### Step 1 
Download all files on your local system via follwing git command
```
git clone https://github.com/taimurkhan911/dcm4chee-arc-5.24.2-installation.git
```
### Step 2 
**Install JDK 11**. 
You can find JDK **jdk-11.0.12_windows-x64_bin.exe** file in **dcm4chee-arc-5.24.2-installation** directory. run the exe file and complete the installation.

Then set **JAVA_HOME** as a **Windows System variable** (needed for the dcm4chee Windows service). Do this after JDK 11 is installed:

1. `Win + R` → type `sysdm.cpl` → Enter  
2. **Advanced** → **Environment Variables**  
3. Under **System variables** (not User variables) → **New**:
   - Variable name: `JAVA_HOME`
   - Variable value: `C:\Program Files\Java\jdk-11.0.12`  
     (use the real folder if the installer used a slightly different name, e.g. `jdk-11.0.1`)
4. In **System variables** → select **Path** → **Edit**:
   - **New** → `%JAVA_HOME%\bin`
   - Move `%JAVA_HOME%\bin` to the **top**
   - If you see `C:\Program Files\Common Files\Oracle\Java\javapath`, that can force **Java 25**. Move it below JDK 11, or the service / `java -version` may pick the wrong Java.
5. Click OK on all windows. **Open a new** Command Prompt (old windows keep the old PATH) and check:

```
echo %JAVA_HOME%
java -version
```

`JAVA_HOME` must print the JDK 11 folder. `java -version` must show **11**, not 17/21/25.

WildFly also pins JDK 11 in `standalone.conf.bat`:

```
set "JAVA_HOME=C:\Program Files\Java\jdk-11.0.12"
```

Keep that line. If Windows `JAVA_HOME` and this line disagree, fix both to JDK 11. After changing environment variables, **restart the dcm4chee service** so it picks up JAVA_HOME.

### Step 3 
**Create database with name pacsdb**. 
and Import SQL file **pacsdb.sql** into it,You can find SQL file  **pacsdb.sql** file in **dcm4chee-arc-5.24.2-installation** directory.
You may need to install jdbc driver mysql. you can find **mysql-installer-web-community-8.0.27.1.msi** in **dcm4chee-arc-5.24.2-installation**

### Step 4 
**Install Apache DS 2**. 
You can find ApacheDS **apacheds-2.0.0.AM26.exe** file in **dcm4chee-arc-5.24.2-installation** directory. run the exe file and complete the installation.

### Step 5 
**Install ApacheDirectoryStudio-2.0.0.v20210717-M17-win32.win32.x86_64**. 
You can find ApacheDS **Install ApacheDirectoryStudio-2.0.0.v20210717-M17-win32.win32.x86_64** file in **dcm4chee-arc-5.24.2-installation** directory. run the exe file and complete the installation. During instalaton. 

### Step 6 
After inatlling a Apache Directory Studio Open it. and create new connectoin with the following credentials 
```
Network Parameter:
    Hostname: localhost
    Port:     10389
Authentication Parameter:
    Bind DN or user: uid=admin,ou=system
    Bind password:   secret
```
### Step 7 

Import LDAP schema files for Apache DS by right click on the connection you created in step 6. Then click on **import**. Then select **LDIF Import**.
A new window will be open. import the following files one by one into it.

```
dcm4chee-arc-5.24.2-installation\dcm4chee-arc-5.24.2-mysql/ldap/apacheds/dicom.ldif
dcm4chee-arc-5.24.2-installation\dcm4chee-arc-5.24.2-mysql/ldap/apacheds/dcm4che.ldif
dcm4chee-arc-5.24.2-installation\dcm4chee-arc-5.24.2-mysql/ldap/apacheds/dcm4chee-archive.ldif
dcm4chee-arc-5.24.2-installation\dcm4chee-arc-5.24.2-mysql/ldap/apacheds/dcm4chee-archive-ui.ldif
```
### Step 8 
One may modify the default Directory Base DN dc=example,dc=com by changing the value of attribute

ads-partitionsuffix: dc=dcm4che,dc=org`

of object
```
ou=config
+ ads-directoryServiceId=default
  + ou=partitions
      ads-partitionId=example

to ads-partitionId=dcm4che
```
## Please look at image How to add values##
![Screenshot](/screenshots/apache-directory-configration.png)

### Step 9 
**Create new user credentials the following data**
![Screenshot](/screenshots/apache-directory-add-new-credentials-step-1.png)
![Screenshot](/screenshots/apache-directory-add-new-credentials-step-2.png)
![Screenshot](/screenshots/apache-directory-add-new-credentials-step-3.png)
![Screenshot](/screenshots/apache-directory-add-new-credentials-step-4.png)
![Screenshot](/screenshots/apache-directory-add-new-credentials-step-5.png)



### Step 10 
**After step 9 is done. Create new connection with the following parameters**

```
Network Parameter:
    Hostname: localhost
    Port:     10389
Authentication Parameter:
    Bind DN or user: cn=admin,dc=dcm4che,dc=org
    Bind password:   secret
Browser Options:
    Base DN: dc=dcm4che,dc=org
```

### Step 11 
Now import the following LDIF files via **Apache Directory Studio** into the connection you have created earlier in **step 6**
```
dcm4chee-arc-5.24.2-installation\dcm4chee-arc-5.24.2-mysql/ldap/init-baseDN.ldif
dcm4chee-arc-5.24.2-installation\dcm4chee-arc-5.24.2-mysql/ldap/init-config.ldif
dcm4chee-arc-5.24.2-installation\dcm4chee-arc-5.24.2-mysql/ldap/default-config.ldif
dcm4chee-arc-5.24.2-installation\dcm4chee-arc-5.24.2-mysql/ldap/default-ui-config.ldif
dcm4chee-arc-5.24.2-installation\dcm4chee-arc-5.24.2-mysql/ldap/add-vendor-data.ldif
```

### Step 12 
Now Copy **wildfly** directory from **dcm4chee-arc-5.24.2-installation** and place it in **C:**
Then change the database connection in C:\wildfly\standalone\configuration\dcm4chee-arc.xml in the following lines if req
```
<datasource jndi-name="java:/PacsDS" pool-name="PacsDS" statistics-enabled="true">
                    <connection-url>jdbc:mysql://localhost:3306/sit_pacs</connection-url>
                    <driver>mysql</driver>
                    <security>
                        <user-name>root</user-name>
                    </security>
</datasource>
```
### Step 13 
 run the follwing command inside wildfly\bin\
```
>C:\wildfly\bin\standalone.bat -c dcm4chee-arc.xml [Windows]
```
After command completed follow the following link 
(http://127.0.0.1:9990/console/index.html)

(http://localhost:8080/dcm4chee-arc/ui2)

This console window is for **first-time setup only** (Step 14 deploy). For live / production, do **not** keep `standalone.bat` open. After deploy, close that window and install the Windows service (Step 17). If WildFly was copied to `D:\wildfly`, use `D:\wildfly\bin\standalone.bat -c dcm4chee-arc.xml` instead.

### Step 14 
http://127.0.0.1:9990/console/index.html#deployments
goto the above page and import the following 2 files in it.

dcm4chee-arc-5.24.2-installation\dcm4chee-arc-5.24.2-mysql\deploy

### Step 15 
 run the follwing command inside dcm4che\bin\ binnery to import data
```
C:\dcm4che-5.24.0\bin>storescu.bat -c DCM4CHEE@localhost:11112 "D:\FAKHOURY-ELIAS-E_RO20517_MR_2021-12-08 09-00-28_44289_202112081638989689_dcm (1)"
```

### Step 16
Install ApacheTomCat and oviyam2.
- Run the dcm4chee-arc-5.24.2-installation\apache-tomcat-8.5.71.exe to install the TomCat
- Copy all files inside **dcm4chee-arc-5.24.2-installation\Oviyam-2.8.1-bin\tomcat** and paste inside C:\Program Files\Apache Software Foundation\Tomcat 8.5\lib 
- Copy file inside **dcm4chee-arc-5.24.2-installation\Oviyam-2.8.1-bin\Oviyam-2.8.1-bin\oviyam2.war** and paste inside C:\Program Files\Apache Software Foundation\Tomcat 8.5\webapps
-  Copy file tomcat-users.xml and server.xml **dcm4chee-arc-5.24.2-installation\Oviyam-2.8.1-bin** and  and paste inside C:\Program Files\Apache Software Foundation\Tomcat 8.5\conf


.![image](/screenshots/oviyam2-config.png)

### Step 17
**Install dcm4chee as a Windows service** (recommended for live). Do **not** double-click `service.bat` (that only prints help). Close the `standalone.bat` window first — do not run the console and the service together.

Open **Command Prompt as Administrator**. Use `C:\wildfly` or `D:\wildfly` — whichever folder you copied in Step 12 / NOTE.

**Create the service (once):**
```
cd /d D:\wildfly\bin\service

service.bat install /startup /config dcm4chee-arc.xml /name dcm4chee /display "dcm4chee Archive" /desc "dcm4chee-arc 5.24 WildFly 24"
```

`/config dcm4chee-arc.xml` is the **file name only** (same as `-c dcm4chee-arc.xml`). Do not pass the full path. The service loads `...\standalone\configuration\dcm4chee-arc.xml`. `/startup` = start on Windows boot.

If WildFly is on `C:`:
```
cd /d C:\wildfly\bin\service

service.bat install /startup /config dcm4chee-arc.xml /name dcm4chee /display "dcm4chee Archive" /desc "dcm4chee-arc 5.24 WildFly 24"
```

**Start the service:**
```
cd /d D:\wildfly\bin\service
service.bat start /name dcm4chee
```
or:
```
net start dcm4chee
```

**Check:**
```
sc query dcm4chee
```
You want `RUNNING`. Then open `D:\wildfly\standalone\log\server.log` (or `C:\wildfly\...`) and confirm WildFly started.

**Stop:**
```
net stop dcm4chee
```
or:
```
cd /d D:\wildfly\bin\service
service.bat stop /name dcm4chee
```

Do **not** use **Restart** in Windows Services (`services.msc`) — it can hang on Stopping. Stop, confirm Java is gone, then start again.

If install says the service already exists:
```
cd /d D:\wildfly\bin\service
net stop dcm4chee
service.bat uninstall /name dcm4chee
```
Then run the `install` command again, then `start`.

JAVA_HOME for the service must be **JDK 11** (Step 2). Do not let the service pick a newer Java from PATH.

### Step 18
**Copy two helper scripts into `wildfly\bin`.** Windows **Restart** in Services (`services.msc`) and `net stop dcm4chee` can hang on **STOP_PENDING** while **Java stays running** on ports 8085 / 11112. These two files kill WildFly Java, then start the service again.

Create (or copy) these files next to `standalone.bat`:

- `D:\wildfly\bin\stop-dcm4chee-java.bat` — kill leftover WildFly `java.exe` only  
- `D:\wildfly\bin\restart-dcm4chee.bat` — kill Java + service wrapper, then `net start dcm4chee`

If WildFly is on `C:`, put them in `C:\wildfly\bin\` and change `D:\wildfly` in the restart script to `C:\wildfly`.

**Do not double-click Restart in Services.** For a live restart, run **as Administrator**:

```
D:\wildfly\bin\restart-dcm4chee.bat
```

To only kill leftover Java (service already STOPPED, but 8085/11112 still listening):

```
D:\wildfly\bin\stop-dcm4chee-java.bat
```

Then `net start dcm4chee` if the service is not running.

**`stop-dcm4chee-java.bat`**
```
@echo off
setlocal
REM Force-stop WildFly Java. Do not use "net stop" here.
echo Killing WildFly Java...
powershell -NoProfile -Command "Get-CimInstance Win32_Process -Filter \"Name='java.exe'\" | Where-Object { $_.CommandLine -match 'jboss-modules\\.jar' } | ForEach-Object { Write-Host ('Killing Java PID ' + $_.ProcessId); Stop-Process -Id $_.ProcessId -Force -ErrorAction SilentlyContinue }"
echo Java stop finished.
endlocal
```

**`restart-dcm4chee.bat`**
```
@echo off
setlocal EnableExtensions
REM Restart service AND Java. Never uses "net stop" (that hangs on STOP_PENDING).
REM Run as Administrator.

echo === Killing WildFly Java ===
powershell -NoProfile -Command "Get-CimInstance Win32_Process -Filter \"Name='java.exe'\" | Where-Object { $_.CommandLine -match 'jboss-modules\\.jar' } | ForEach-Object { Write-Host ('Killing Java PID ' + $_.ProcessId); Stop-Process -Id $_.ProcessId -Force -ErrorAction SilentlyContinue }"

echo === Killing service wrapper if still running ===
for /f "tokens=3" %%A in ('sc queryex dcm4chee ^| findstr /C:"PID"') do (
  if not "%%A"=="0" (
    echo Killing service PID %%A
    taskkill /PID %%A /F /T >nul 2>&1
  )
)
taskkill /F /IM wildfly-service.exe /T >nul 2>&1

echo Waiting for service to report STOPPED...
timeout /t 5 /nobreak >nul

echo === Starting Windows service (this starts Java) ===
net start dcm4chee

echo === Status ===
sc query dcm4chee
echo Check D:\wildfly\standalone\log\server.log for WFLYSRV0025
pause
endlocal
```

After restart, confirm `sc query dcm4chee` is `RUNNING` and `server.log` contains `WFLYSRV0025` (WildFly started).

#### Please NOTE
```
Please copy "dcm4che-5.24.0-bin" to C: and rename to dcm4che-5.24.0
"wildfly-copy" copy to D: and rename to wildfly
"Tomcat 8.5 -Copy to Tomcat Apache" copy to Tomcat Apache
"ext-install" have ext files install it from there
in My Google Drive Dir with name  "NEW-SERVER-INSTALL" has some files need to be download
run  vcredist_x64.exe  afere wanp insall
You may need to create Temp file in C:\Windows\System32\config\systemprofile\AppData\Local\Temp
```

