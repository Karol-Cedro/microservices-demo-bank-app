build-all:
	cd accounts && mvn clean install && \
	cd ../cards && mvn clean install && \
	cd ../operations && mvn clean install && \
	cd ..

build-images-all:
	cd accounts && docker build -t accounts . && \
	cd ../cards && docker build -t cards . && \
	cd ../operations && docker build -t operations . && \
	cd ../

run-all-containers:
	docker-compose up -d

stop-all-containers:
	docker-compose down