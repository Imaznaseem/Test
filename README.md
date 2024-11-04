# Cariogram Application

Cariogram is a Java-based application designed to analyze and visualize dental health risk factors. This application includes a backend developed with Spring Boot and an interactive front end that presents the data in a user-friendly chart. The project is hosted on Render, ensuring high availability and ease of deployment.

## Project Overview

Cariogram helps dental professionals assess a patient's caries risk by analyzing various health parameters. Users input specific risk factors, and the application generates a visual cariogram (chart) displaying the likelihood of caries based on these inputs.

This application was built with a robust backend in Java and a front-end for easy interaction, making it an ideal tool for assessing caries risk quickly and accurately.

## Features

- **Risk Factor Analysis**: Calculates and visualizes risk factors for caries development.
- **Interactive Frontend**: Displays an interactive chart that updates dynamically based on user input.
- **RESTful API**: Provides a flexible API for data input, allowing easy integration with other systems or front ends.
- **Real-Time Feedback**: Instant chart updates as risk factors are adjusted.
- **Secure Deployment**: Hosted on Render for secure, scalable access.

## Architecture

The application is divided into a frontend and a backend:

- **Frontend**: HTML, CSS, and JavaScript hosted alongside the backend, providing an interactive user experience.
- **Backend**: Built with Spring Boot, handling API requests and processing risk factor data to produce the cariogram analysis.

## Technologies Used

- **Java 21**: Core programming language used for the backend.
- **Spring Boot**: Backend framework for building RESTful services.
- **JavaScript, HTML, CSS**: For the frontend interface.
- **Render**: Deployment platform used for hosting the full-stack application.
- **Maven**: Build and dependency management tool.

## Setup and Installation

To set up and run the Cariogram project locally, follow these steps:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/cariogram.git
   cd cariogram

2. **Build the Project: Ensure you have Maven installed, then package the application:**:
   ```bash
   mvn clean package

3. **Run the Application: Run the JAR file generated in the target directory:**:
   ```bash
   java -jar target/Cariogram-Backend-0.0.1-SNAPSHOT.jar

4. **Access the Application:**:
   Open your browser and go to http://localhost:8080 to access the Cariogram interface.

   
## Future Enhancements
- Database Integration: Store user input and analysis history for longitudinal studies.
- Mobile Support: Enhance UI for better performance on mobile devices.
