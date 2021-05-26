TELEGRAM BOT

Application:
Spring boot application with MongoDB.
Java packages: io.project.app.addressbook
**Logic:**
Telegram bot allows subscribers create and manage their own address book.

Actions:

**• /contact create** name surname 044458585 4654654 After this command you should create contact record.
**• /contact all** must return all created contacts. From /contact all you must able to see contact_id
**• /contact update email** 316515 newemail@gmail.com after this command system must update only contact email.
**• /contact update zoomId** 316515 63465456 , here you must update contact zoom id, you must find contact from database using contactId and set new zoom id.
**• /contact delete** contact_id must delete contact from address book.
**• /contact search** name surname , search contact by name

**RUN**
docker-compose  up -d --build 

**Scripts**
./look.sh - you can look at logs
./clean.sh - you can clean docker images
./restart.sh addressbook - you can restart the application
