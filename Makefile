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

deploy-on-minikube:
	minikube image load accounts:latest && \
	minikube image load cards:latest && \
	minikube image load operations:latest && \
	kubectl apply -f accounts/deployment && \
	kubectl apply -f cards/deployment && \
	kubectl apply -f operations/deployment

clear-ports:
	sudo lsof -i :8080 -t | xargs sudo kill -9 && \
	sudo lsof -i :8090 -t | xargs sudo kill -9 && \
	sudo lsof -i :9000 -t | xargs sudo kill -9

forward-ports:
	kubectl port-forward svc/accounts-service 8080:8080 & \
	kubectl port-forward svc/cards-service 8090:8090 & \
	kubectl port-forward svc/operations-service 9000:9000 &

delete-from-minikube:
	kubectl delete -f accounts/deployment && \
	kubectl delete -f cards/deployment && \
	kubectl delete -f operations/deployment