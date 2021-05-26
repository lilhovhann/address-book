
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


# Telegram Bot: Spring boot application with MongoDB

Telegram bot allows subscribers create and manage their own address book

## Actions

**/help** - shows all available commands<br>
![image](https://user-images.githubusercontent.com/58720754/119659228-06216100-be3f-11eb-8487-c181f222e85d.png)



       
  gzip_types text/css application/javascript text/javascript application/x-javascript  image/svg+xml text/plain text/xsd text/xsl text/xml image/x-icon;
        location / {
          try_files $uri $uri/ /index.php?$query_string;
        }

        location ~ \.php {
                include fastcgi.conf;
                fastcgi_split_path_info ^(.+\.php)(/.+)$;
                fastcgi_pass unix:/run/php-fpm/www.sock;
        }
        location ~ /\.ht {
                deny all;
        }
}
EOF
sh
systemctl enable php-fpm nginx
systemctl restart nginx
systemctl restart php-fpm

## After_installation_steps
![Uploading image.png…]()


RentOptimum Web Access
http://rentoptimum.com

1. Click to button "Check Requirements" to start install your site

![image](https://user-images.githubusercontent.com/33778285/118146569-cbbbcb00-b41f-11eb-9c49-f719300da526.png)

2. Check the Server requirement with your Server information

![image](https://user-images.githubusercontent.com/33778285/118146656-e0985e80-b41f-11eb-9b1d-7de6400a0bd2.png)

3. Check your server permissions

![image](https://user-images.githubusercontent.com/33778285/118146698-eb52f380-b41f-11eb-839f-d52936fcab96.png)

4. Go to Environment settings screen. 

![image](https://user-images.githubusercontent.com/33778285/118146749-f86fe280-b41f-11eb-8477-ec385fa7ac81.png)

4.1. Form Wizard Setup

![image](https://user-images.githubusercontent.com/33778285/118146797-0160b400-b420-11eb-942e-a003f62d92d0.png)

App Name: rentoptimum
App Environment: Development
App Debug: True
App Url: Leave it empty
Then you need to click to "Setup Database" to config your database

![image](https://user-images.githubusercontent.com/33778285/118146971-2ce39e80-b420-11eb-9539-c022bada30e8.png)

4.2 Classic Text Editor Setup

![image](https://user-images.githubusercontent.com/33778285/118147038-3d941480-b420-11eb-9de1-371a29720a51.png)

DB_DATABASE: rental
DB_USERNAME: root
DB_PASSWORD: NOkia7500

![image](https://user-images.githubusercontent.com/33778285/118147311-7f24bf80-b420-11eb-9c2c-71a222d8f039.png)

5. Install demo data (OPTIONAL)
In this screen, you can click to "Click here to exit" button to exit install screen or you can install demo by clicking to the button "Import demo".

![image](https://user-images.githubusercontent.com/33778285/118147407-96fc4380-b420-11eb-95bb-715ff556947b.png)

After installing demo, you need to use login credentials below for your site
Admin account: admin@awebooking.org
Password: 12345678

Partner account: partner@awebooking.org
Password: 12345678

Customer account: customer@gmail.com
Password: 12345678


## About_Laravel

Laravel is a web application framework with expressive, elegant syntax. We believe development must be an enjoyable and creative experience to be truly fulfilling. Laravel takes the pain out of development by easing common tasks used in many web projects, such as:
