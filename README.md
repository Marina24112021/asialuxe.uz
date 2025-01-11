<h2>Проект автоматизации тестирования туристического агентсва <a target="_blank" href="https://asialuxe.uz/ru"> Asialuxe.uz</a></h2>
<p>
<img src="images/dashbord.png">
</p>

## Содержание
+ [Описание](#Описание)
+ [Технологии и инструменты](#Технологии-и-инструменты)
+ [Реализованные проверки](#Реализованные-проверки)
+ [Запуск тестов](#Запуск-тестов)
    + [Допустимые комбинации](#Схема-комбинаций-по-запуску-автотестов)
    + [Локальный запуск тестов](#Локальный-запуск-тестов)
    + [Удаленный запуск тестов](#Удаленный-запуск-тестов)
+ [Cборка тестов в Jenkins](#Cборка-тестов-в-Jenkins)
+ [Интеграция с Allure Report](#интеграция-с-allure-report)
    + [Диаграммы прохождения тестов](#Диаграммы-прохождения-тестов)
    + [Развернутый результат прохождения тестов](#Развернутый-результат-прохождения-тестов)
+ [Интеграция с Allure TestOps](#Интеграция-с-Allure-TestOps)
+ [Интеграция с Jira](#Интеграция-с-Jira)
+ [Уведомления в Telegram с использованием бота](#Уведомления-в-Telegram-с-использованием-бота)
+ [Пример выполнения теста в Selenoid](#Пример-выполнения-теста-в-Selenoid)

## Описание
Asialuxe Travel — крупнейший туроператор Узбекистана, предлагающий высококачественные услуги как для выездного, так и въездного туризма. <br/>

**Особенности проекта**:
- `Page Object` шаблон проектирования
- Использование техноголии `Owner` для придания тестам гибкости и легкости конфигурации
- Возможность запуска тестов: локально, удалённо, по тегам
- Использование `Faker` для генерации данных
- Использование `Lombok` для моделей в API тестах
- Использование собственных расширений:
    - `@WithLogin` для предварительной авторизации 
- Возможность запуска тестов напрямую из Allure TestOps
- Уведомление о результатах прохождения в Telegram
- По итогу прохождения автотестов генерируется Allure отчет. Содержание отчета:
    - Шаги теста
    - Скриншот страницы на последнем шаге
    - Исходный код страницы в браузере
    - Логи консоли браузера
    - Видео выполнения автотеста

## Технологии и инструменты
<div>
<a href="https://www.java.com/"><img alt="Java" height="50" src="images/logo/Java.svg" width="50"/></a>
<a href="https://github.com/"><img alt="GitHub" height="50" src="images/logo/GitHub.svg" width="50"/></a>  
<a href="https://www.jenkins.io/"><img alt="Jenkins" height="50" src="images/logo/Jenkins.svg" width="50"/></a>
<a href="https://www.browserstack.com/"><img alt="Browserstack" height="50" src="images/logo/Browserstack.svg" width="50"/></a>
<a href="https://rest-assured.io/"><img alt="RestAssured" height="50" src="images/logo/RestAssured.svg" width="50"/></a>
<a href="https://junit.org/junit5/"><img alt="JUnit 5" height="50" src="images/logo/Junit5.svg" width="50"/></a>
<a href="https://selenide.org/"><img alt="Selenide" height="50" src="images/logo/Selenide.svg" width="50"/></a>
<a href="https://aerokube.com/selenoid/"><img alt="Selenoid" height="50" src="images/logo/Selenoid.svg" width="50"/></a>
<a href="https://www.jetbrains.com/idea/"><img alt="InteliJ IDEA" height="50" src="images/logo/Idea.svg" width="50"/></a>
<a href="https://github.com/allure-framework/"><img alt="Allure Report" height="50" src="images/logo/Allure.svg" width="50"/></a>
<a href="https://gradle.org/"><img alt="Gradle" height="50" src="images/logo/Gradle.svg" width="50"/></a>  
<a href="https://appium.io/"><img alt="Appium" height="50" src="images/logo/Appium.svg" width="50"/></a>
<a href="https://developer.android.com/studio"><img alt="Android Studio" height="50" src="images/logo/Android_Studio.svg" width="50"/></a>
<a href="https://qameta.io/"><img alt="Allure TestOps" height="50" src="images/logo/Allure_TO.svg" width="50"/></a> 
<a href="https://telegram.org/"><img alt="Telegram" height="50" src="images/logo/Telegram.svg" width="50"/></a>
</div>

## Реализованные проверки
### Web
- [x] Проверка заголовок меню на домашней странице
- [x] Проверка поисковой панели на домашней странице
- [x] Проверка наличия текста в блоке Почему мы
### Api
- [x] Выполнение успешного запроса на авторизацию
- [x] Выполнение успешного запроса поиск билетов
- [x] Выполнение успешного запроса получения данных о рейсе
- [x] Выполнение успешного запроса по получения список предлагаемых тарифов
- [x] Выполнение успешного запроса по получения одобрения по предварительному бронированию билета от авиакомпании
- [x] Выполнение успешного запроса по получения одобрения бронирование билета  
### Mobile
- [x] Проверка заголовка странице Профиль-> О Компании
- [x] Проверка заголовок на домашней странице
- [x] Проверка заголовка странице Профиль-> Архив акций
- [x] Проверка адреса филиала на странице Профиль-> Где купить?
### Ручные проверки

## Запуск тестов

### Схема комбинаций по запуску автотестов

```mermaid 
flowchart LR
    A(gradle) --> B(clean)
    B --> C{Выбрать тег}
    C --> D[test]
    C --> E[web]
    C --> F[api]
    C --> G[android]
    E --> H[-DenvWeb=local]
    E --> I[-DenvWeb=remote]
    G --> J[-DenvMobile=browserstack]
    G --> K[-DenvMobile=emulator]
    G --> L[-DenvMobile=localDevice]
```
### Локальный запуск тестов
#### Запуск всех тестов

Для запуска следует открыть IntelliJ IDEA и выполнить в терминале:
```
gradle clean test
```

или

```
gradle clean test -Denv=local
```
#### WEB

```
gradle clean web
```


#### API
```
gradle clean api 
```

#### Mobile

```
gradle clean android -DenvMobile=${ENV_MOBILE}
```