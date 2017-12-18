# SpringBoot and Elastic Search Example on Cloud Foundry

## Install PKS with Elastic Search

## Install the Spring Boot application on PAS
This is a sample SpringBoot application that performs Geo Bounded queries against an Elastic Search instance and plots the data on a map interactively. This application can be run on a workstation or in a cloud environment such as Cloud Foundry. In this example, I will show how to deploy the application on a running Cloud Foundry instance. 

Please follow these steps to deploy this application.

1. Build the project locally
<ul><pre>mvn clean package</pre></ul>

2. Initialize the Elastic Search service with Geo Location data. Update the scripts with the Elastic Search Service endpoints.
<ul><pre>src/main/resources/data/create_schema.sh</pre></ul>
<ul><pre>src/main/resources/data/insert_big_cities.sh</pre></ul>

3. Now create a User Provided Service that binds an external Elastic Search instance to the application.
<ul><pre>cf create-user-provided-service es-service -p '{"url":"http://{elastic-search-host}","port":"{elastic-search-port}","esindex":"{index-name}"}'</pre></ul>

4. Push the application to Cloud Foundry. The manifest.yml has a dependency on the user provided service created above.
<ul><pre>cf push</pre></ul>

## Testing the application

1. Navigate to the route thats created for the application.
