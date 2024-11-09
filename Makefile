build-all:
	cd accounts && mvn clean install -DskipTests && \
	cd ../cards && mvn clean install -DskipTests && \
	cd ../operations && mvn clean install -DskipTests && \
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

all: build-all build-images-all run-all-containers