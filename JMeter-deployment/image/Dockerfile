# Use a base image with Java pre-installed
FROM openjdk:11-jdk-slim

# Set environment variables
ENV JMETER_VERSION=5.6.1
ENV JMETER_HOME=/opt/jmeter
ENV PATH="${JMETER_HOME}/bin:${PATH}"

# Install dependencies and JMeter
RUN apt-get update && apt-get install -y \
    wget \
    unzip \
    && rm -rf /var/lib/apt/lists/*

# Download and extract JMeter
RUN wget -q https://downloads.apache.org/jmeter/binaries/apache-jmeter-${JMETER_VERSION}.tgz \
    && tar -xzf apache-jmeter-${JMETER_VERSION}.tgz -C /opt \
    && mv /opt/apache-jmeter-${JMETER_VERSION} ${JMETER_HOME} \
    && rm apache-jmeter-${JMETER_VERSION}.tgz

# Add a directory for test scripts and configuration
RUN mkdir -p ${JMETER_HOME}/tests

# Copy your test plans and configuration (if any)
# Uncomment if you have pre-defined test scripts
# COPY tests/ ${JMETER_HOME}/tests/

# Set the working directory
WORKDIR ${JMETER_HOME}

# Default command to run JMeter
CMD ["jmeter", "-n"]
