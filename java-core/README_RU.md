# Финальный проект по Java Core

## Для запуска инфраструктуры используйте команду

```bash
docker compose --project-directory ./infra/ up
```

## Для запуска финального проекта используйте команду: 

```bash
java -jar ./artifact/TMS_Java_core_final_project.jar
```

## Описание проекта
1. При старте программы пользователь должен выбрать рабочую папку 
для хранения данных программы (файла счетов и файла отчёта).
2. После выбора папки и наличия в ней файла со счетами, работа 
будет вестись с этим файлом; если файла счёта нет, создаётся 
новый файл с заранее определёнными счетами. 
3. После правильно указанной рабочей папки, пользователю 
будет предложено несколько операций. 
   - **1 - парсинг** (осуществятся переводы из папки `input` внутри
   рабочей папки. Если заранее положить в нее переводы в формате **txt**. 
   Разобранные файлы будут перемещены в папку `archive`).
   - **2 - отчёт** (выводится ссылка на отчёт).
   - **3 - отчёт за период** (сначала будет запрошен период, за который нужно сформировать отчёт,
затем выведется отчёт за выбранный период).
   - **q - выход** (выполняется выход из приложения).
4. Для доступа к базе данных можно воспользоваться инструментом **pgAdmin**, 
который поставляется вместе с инфраструктурой.  
   - Перейдите по ссылке [pgAdmin](http://localhost:5050/) и введите:  
     - Логин: `admin@example.com`  
     - Пароль: `adminpassword`  
5. Для подключения к базе данных используйте следующую конфигурацию:  
   - Адрес сервера: `postgres_container`  
   - Порт: `5432`  
   - База данных: `postgres_db`   
   - Имя пользователя: `postgres_user`   
   - Пароль: `postgres_password`   
6. Инициализация схемы базы данных выполняется автоматически.
7. Диаграмма классов доступна по ссылке: [Классы](https://www.plantuml.com/plantuml/umla/hLVhRfmu5FxFKtYd_vgCr5PQgOkYKGd3g5GPPfPBBsehv82Je0KRsQRRgkeJzH7whqzM6qm64qoIDemqWdFixvppdOlX1UEGygOgBUilVeKg1EeI5jZYf0QSW7F2EQb0Nb2KyO9WY_rNu1fIM86om8X_gH4Wb5yHoyfAo1Xmiemqc8El5W1BS0vBY3DaWvmqvoLgPRYfpX6rGSHfWI-jR_f65X2-4JUvzpb3TMkoqxloVm_vLOWOQMY6-eMzdc16IfJmecJAUkGwGU25mbG6CKRqsjOQSdWA6H8s4MDZIxqsgNF8qK6BC2_u5wb6UqGBaeEJ4o1u8JG7gvMosT8fbzZWZ6ImbBUj0k5yBExTsHJAR_Niuq-mB7B5Y7HdxEAhzQaxZ3I9sZ0xHgL0BaYJy4mJxfqeUhCBrpUutugCXqrBKIS8KIso6Y7wgSYGiX5xstqQUljT6ASR_ynBzw6tyTzg5WRgmDbwckv_GaNjNAuBAhDe0_alF42Y7e0m7ijI4eJAPqIX3BPdzKZXsc3ma9w-I_TUwE_MIlnludShbY0ZEHhOFW9nw0JHHdBKMcpp6AFFN3BlumiobKbPtqoags3yf8DQjV9ww7r7LqmXPXU8gfqNb5GgUO5Ux5BBYLd7cahhbLolcBYeElc5y3k05RgHoTuJfwxB8kjOx9pYIgEIQbylLO9s4HtctTRBOC2SsYawiIdv57TSMn5no1icUUxvZ0twbRRxuAF9zc6deHU5TX1f-pnGRKNtmqipYte3EA7xqd_jfMi_zDnu5xwxlRobmW_sIMpOvBZkBWdYQBfZe1g9jcZGMjNWSJyeLttlwD4PMyWFecIpyLtV2qI39i4wKdqJ9QxhHVsJ7xnsplnrkWbtspH8jgTjqqXDi1FxXBTJkdvNb6n7aa7dQUAT2Noe-MPPrxCHJ5pBzu_-_aV-ZdF8hb3-SRa2veD2RB31ukVtZ2BHIpz_B7u3N1iQesi4VfZHTmKt74jJu8U9VMVF9oQ3mNDz-j_7yz6H-M3W_O4BRk6yFqSchoE1_lpP4t4Tj-yu7vVph5XpoiNJ1NXyS5S1hi126w4Vi5Ws5_6iZMawvk16TFnM0AE3eWrXF13_C8GvE4C8wgpHhbj3q7oVAWdBU9pSLZ1J_ioY6PtjZYATvcwKJuDFaMO4xu-G3_ZnulhTV9Q9oSAQpE8Sd26BzmQ_-Jdm4E3t65Vt1vzvU_zpyBbYVZ3mgTf-O72zDqpW4srmXwRKiQqNuijBVj_-0W00)
8. Данные для тестирования доступны в папке `data`.
