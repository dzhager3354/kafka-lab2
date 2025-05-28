# Лабораторная работа №1 - Docker
Лаба **уже поднята** на личной тачке [тыкни на меня](http://77.90.33.48:8080). Можно сразу перейти к [тестированию endpoint'ов](#test) 

Или поднять проект локально и выполнить [тестирование](#test)
## Установка
1. Склонируйте проект
```git clone https://github.com/dzhager3354/kafka-lab2.git```

3. Перейдите в склоненную папку
```cd kafka-lab2```

4. Запустите билд композа
```docker-compose --env-file app.env build```

`app.env` нужен для удобного конфигурирования открытого порта приложения.

Измените параметр `API_PORT` в `app.env` для открытия api сервиса на другом порту.

6. Запуск получившегося образа
```docker-compose --env-file app.env up```

## <a id="test">Тестирование приложения </a>
Приложение представляет собой 2-х табличное приложение. 
Формат хранимых объектов:
Таблица `Players`
```json
{
  "id": 0,
  "nickname": "",
  "dateRegistration": "2025-05-03"
}
```
Поле `nickname` является **обязательным** и **уникальным**

Таблица PlayerData
```json
{
  "id": 0,
  "playerId": 0,
  "server": "hitech",
  "playtime": 0
}
```

### API
- GET: /player
  
  Возвращает список всех игроков
  
  Принимаемые параметры: нет

  Curl: ```curl http://77.90.33.48:8080/player```

- POST: /player
  
  Создаёт игрока и возвращает статус создания
  
  Принимаемые параметры: `nickname`
  ```json
  {
    "nickname": ""
  }
  ```

  Curl: ```curl --header "Content-Type:application/json" --request POST --data '{"nickname":"privet"}' http://77.90.33.48:8080/player```

- POST: /playerdata
  
  Создаёт игровые данные игрока и возвращает статус создания
  
  Принимаемые параметры: `playerId, server`
  ```json
  {
    "server": "dtm",
    "playerId": 1
  }
  ```

  Curl: ```curl --header "Content-Type:application/json" --request POST --data '{"server":"dgt", "playerId": 1}' http://77.90.33.48:8080/playerdata```

- PUT: /playerdata
  
  Обновляет игровые данные игрока и возвращает статус создания
  
  Принимаемые параметры: `id, playtime`
  ```json
  {
    "id": 1,
    "playtime": 100
  }
  ```

  Curl: ```curl --header "Content-Type:application/json" --request PUT --data '{"id":1, "playtime": 100}' http://77.90.33.48:8080/playerdata```

- GET: /playerdata/top?server=
  
  Возвращает топ игроков по онлайну на выбранном сервере
  
  Принимаемые параметры: `server`

  Curl: ```curl --header "Content-Type:application/json" --request GET http://77.90.33.48:8080/playerdata/top?server=```

- GET: /playerdata/global
  
  Возвращает суммарный онлайн всех игроков
  
  Принимаемые параметры: `нет`

  Curl: ```curl --header "Content-Type:application/json" --request GET http://77.90.33.48:8080/playerdata/global```

- GET: /playerdata/total?server=
  
  Возвращает суммарный онлайн игроков на выбранном сервере
  
  Принимаемые параметры: `server`

  Curl: ```curl --header "Content-Type:application/json" --request GET http://77.90.33.48:8080/playerdata/total?server=```