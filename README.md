<h1 align="center">
  CSV Parser and Joiner
</h1>


## 🍔 Install project

1.  **Fetch project**

    Use git to fetch project on you local machine.

    ```sh
    git clone git@github.com:lsarkisov/CSVParserAndJoiner.git
    ```

3.  **Requirements.**

    For running this project you need to use Java 13 and Maven
    Open your terminal and run in project root
    ```mvn install``` for first time or ```mvn clean install``` for all other cases.
    After that run ```java -cp target/csv_parser-1.0-SNAPSHOT.jar com.lv.app.Application```
    In the root directory you will see <b>result.csv</b>
    The file should contain this result:
    ```
    id,name,surname,department,department_id
    1,John,Smith,Marketing,2
    2,Pete,Hallock,Management,1
    3,Freddie,Ruckman,Finance,4
    4,Lee,Alen,Production,4
    ```
