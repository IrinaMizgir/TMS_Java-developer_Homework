# Java Core final project

## To start the infrastructure, use the command

```bash
docker compose --project-directory ./infra/ up
```

## To run the final project, use the command:

```bash
java -jar ./artifact/TMS_Java_core_final_project.jar
```

## Project Description
1. When the program starts, the user must select a working folder
   for storing program data (the accounts file and the report file).
2. After selecting the folder, if it contains an accounts file, the work
   will proceed with this file; if there is no accounts file, a
   new file with predefined accounts is created.
3. Once the working folder is correctly specified, the user
   will be offered several operations:
   - **1 - парсинг** (transfers will be processed from the `input` folder inside
     the working folder. You can place transfers in **txt** format there in advance.
     Processed files will be moved to the `archive` folder).
   - **2 - отчёт** (a link to the report is displayed).
   - **3 - отчёт за период** (first, the period for which the report should be generated will be requested,
     then the report for the selected period will be displayed).
   - **q - выход** (exits the application).
4. To access the database, you can use the **pgAdmin** tool,
   which is included with the infrastructure. 
   - Go to [pgAdmin](http://localhost:5050/) and enter:  
     - Login: `admin@example.com`  
     - Password: `adminpassword`  
5. To connect to the database, use the following configuration:
   - Server address: `postgres_container`  
   - Port: `5432`  
   - Database: `postgres_db`   
   - Username: `postgres_user`   
   - Password: `postgres_password`   
6. Database schema initialization is performed automatically.
7. Classes diagram available at [Classes](https://www.plantuml.com/plantuml/umla/hLVhRfmu5FxFKtYd_vgCr5PQgOkYKGd3g5GPPfPBBsehv82Je0KRsQRRgkeJzH7whqzM6qm64qoIDemqWdFixvppdOlX1UEGygOgBUilVeKg1EeI5jZYf0QSW7F2EQb0Nb2KyO9WY_rNu1fIM86om8X_gH4Wb5yHoyfAo1Xmiemqc8El5W1BS0vBY3DaWvmqvoLgPRYfpX6rGSHfWI-jR_f65X2-4JUvzpb3TMkoqxloVm_vLOWOQMY6-eMzdc16IfJmecJAUkGwGU25mbG6CKRqsjOQSdWA6H8s4MDZIxqsgNF8qK6BC2_u5wb6UqGBaeEJ4o1u8JG7gvMosT8fbzZWZ6ImbBUj0k5yBExTsHJAR_Niuq-mB7B5Y7HdxEAhzQaxZ3I9sZ0xHgL0BaYJy4mJxfqeUhCBrpUutugCXqrBKIS8KIso6Y7wgSYGiX5xstqQUljT6ASR_ynBzw6tyTzg5WRgmDbwckv_GaNjNAuBAhDe0_alF42Y7e0m7ijI4eJAPqIX3BPdzKZXsc3ma9w-I_TUwE_MIlnludShbY0ZEHhOFW9nw0JHHdBKMcpp6AFFN3BlumiobKbPtqoags3yf8DQjV9ww7r7LqmXPXU8gfqNb5GgUO5Ux5BBYLd7cahhbLolcBYeElc5y3k05RgHoTuJfwxB8kjOx9pYIgEIQbylLO9s4HtctTRBOC2SsYawiIdv57TSMn5no1icUUxvZ0twbRRxuAF9zc6deHU5TX1f-pnGRKNtmqipYte3EA7xqd_jfMi_zDnu5xwxlRobmW_sIMpOvBZkBWdYQBfZe1g9jcZGMjNWSJyeLttlwD4PMyWFecIpyLtV2qI39i4wKdqJ9QxhHVsJ7xnsplnrkWbtspH8jgTjqqXDi1FxXBTJkdvNb6n7aa7dQUAT2Noe-MPPrxCHJ5pBzu_-_aV-ZdF8hb3-SRa2veD2RB31ukVtZ2BHIpz_B7u3N1iQesi4VfZHTmKt74jJu8U9VMVF9oQ3mNDz-j_7yz6H-M3W_O4BRk6yFqSchoE1_lpP4t4Tj-yu7vVph5XpoiNJ1NXyS5S1hi126w4Vi5Ws5_6iZMawvk16TFnM0AE3eWrXF13_C8GvE4C8wgpHhbj3q7oVAWdBU9pSLZ1J_ioY6PtjZYATvcwKJuDFaMO4xu-G3_ZnulhTV9Q9oSAQpE8Sd26BzmQ_-Jdm4E3t65Vt1vzvU_zpyBbYVZ3mgTf-O72zDqpW4srmXwRKiQqNuijBVj_-0W00)
8. Test data is available in the `data` folder.
