# SpringBoot and Elastic Search Example on Cloud Foundry

## Install PKS with Elastic Search
This section involves a couple of steps: install PKS on a supported IaaS, install Elastic Search on the deployed Kubernetes cluster and load the Location data. We will use a sample dataset in this case, but you can load any other Positional data of your choice and have it display on the map accordingly. This is a good website to download Location data based on your specific customer's need. 

[Location Data Source](https://www.aggdata.com)

[Deploying Elastic Search on Kubernetes](https://github.com/kubernetes/examples/tree/master/staging/elasticsearch)

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

<img src="https://github.com/gvijayar/springboot-elasticsearch/blob/master/docs/default.jpg" width="80%"/>

2. You can now interact with the map by zooming in/out or shifting the focus. It should execute a new Geo Positional query against PKS and repaint the map.

<img src="https://github.com/gvijayar/springboot-elasticsearch/blob/master/docs/zoom.jpg" width="80%"/>
