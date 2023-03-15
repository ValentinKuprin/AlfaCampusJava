# В данном проекте будут храниться Домашние задания

## Правила сдачи ДЗ:
1. Домашняя работа должна быть оформлена в соответствии с требованиями, указанными перед заданиями или разделом (в случае наличия таких требований).
2. Срок сдачи - до 10:00 (GMT +3) первого рабочего дня после выходных (как правило это будет до 10:00 (GMT +3) понедельника).
3. В случае опоздания домашнее задание считается **невыполненным**.
4. Две **не сданные работы** означают автоматическое **отчисление с курса**.

## !!! Перед выполнением не забудьте подтянуть изменения в свои проекты!!!
1. В папке проекта, в консоли введите команду
   git remote add upstream [git@www.gitlab-alfa-campus.ru](mailto:git@www.gitlab-alfa-campus.ru):qa/lesson_1.git
2. Перейти в ветку main
3. Выполнить команду git pull origin main (Тут вы подтянули предыдущую проверенную домашку. Вам же смержили ваш предыдущий MR?)
4. Выполнить команду  git pull upstream main (Тут вы подтянули новую домашку с мастер-репозитория)
5. Проверить, что папка с ДЗ появилась в локальном проекте и вы стоите в ветке main
6.  Выполнить команду  git push origin main (Тут задание с новой домашкой улетело в вашу удаленную репу, чтоб потом файлов с заданиями не было в MR)
7. Проверить, что появилась папка с ДЗ в гит-лабе в ветке main
8. Создаем локальную ветку командой git checkout -b <название ветки>
9. Вы великолепны!

Если что-то накосячил (вдруг), то сделай так:

1. git remote rm upstream
2. git remote add upstream [git@www.gitlab-alfa-campus.ru](mailto:git@www.gitlab-alfa-campus.ru):qa/lesson_1.git
3. Повторяем с пункта 2 инструкции 😎

Не забывайте про правила оформления МР (см.Notion)

Для выполнения заданий по теории удобно будет использовать плагин для работы с тектсовыми файлами adoc (скачивается и устанавливается в IDE)

## Оглавление

1. [HW1](HW1/HW1.md)
2. [HW2](HW2/HW2.md)
3. [sql_HW3](sql_HW3/SQL_Part1.md)
4. [sql_HW3](sql_HW3/SQL_Part2.md)
5. [RestPostman_HW4](RestPostman_HW4/REST.md)
6. [RestPostman_HW4](RestPostman_HW4/POSTMAN_WS.md)
7. [HW reactive strategy](ReactiveStrategy/HWrs.md)
8. [HW bug reports](BugReports/HW6.md)
9. [JavaHW](JavaHW/Java_Part1.md)
10. [JavaHW](JavaHW/Java_Part2.md)
11. [JavaHW2_OOP](JavaHW2_OOP/README.md)
12. [HW_JAVA_5_Exceptions]
13. [HW_JAVA_7_Collections]
14. [junit-hw](junit-hw/README.md)
15. [HW_Selenium](HW_Selenium/hw.md)
16. [HW_Selenide](HW_Selenide/selenideHW.md)
17. [appiumHW](README.md)
