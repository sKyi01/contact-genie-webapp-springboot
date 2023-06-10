# ***contact-genie-webapp-springboot***
# Contact Genie
Contact Genie is a web application that allows users to manage their contacts. It provides CRUD (Create, Read, Update, Delete) functionality for contacts, along with various features for authentication, security, and user management.

# Features
### User Authentication: 
                        Contact Genie utilizes Spring Security for user authentication. Users can register, log in, and log out securely.
# Token-based Verification:
                           Authentication is performed using tokens with an expiration time. This adds an extra layer of security to the application.
# Change Password:
                  Users can change their passwords within the application to maintain account security.
# Contact Management:
                      Users can perform CRUD operations on their contacts, including creating new contacts, viewing details, updating information, and deleting contacts.
# Relational Mapping: 
                     The application uses Hibernate for object-relational mapping. It establishes a one-to-many relationship between users and contacts, ensuring data consistency.
# Validation: 
              Hibernate validation and a Validator dependency are implemented to enforce constraints on data, ensuring data integrity.
# UI Rendering: 
               Thymeleaf, a server-side Java templating engine, is used for rendering dynamic HTML pages and providing a smooth user interface.
# Database: 
           Oracle is used as the backend database to store contact and user information reliably.
# Technologies Used
Java
Spring Boot
Hibernate
Spring Security
Thymeleaf
Oracle Database
# Getting Started
Clone the repository: git clone https://github.com/yourusername/contact-genie.git
Configure the Oracle database and update the application properties with the necessary database credentials.
Build the project using Maven: mvn clean install
Run the application: mvn spring-boot:run
Access the application in your browser: http://localhost:8080
# Contributing
Contributions are welcome! If you'd like to contribute to Contact Genie, please follow these steps:

Fork the repository.
Create a new branch for your feature: git checkout -b feature-name
Make your changes and commit them: git commit -m 'Add some feature'
Push the changes to your fork: git push origin feature-name
Open a pull request in the original repository.
# License
This project is licensed under the MIT License.

Feel free to customize this README file according to your project's specific details and requirements.
