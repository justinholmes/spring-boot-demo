#!/usr/bin/env bash

if [ $# -ne 2 ] ; then 
  echo "Usage: $0 [POM_ARTIFACTID] [BUILD_NUMBER]"
  exit 1
fi

POM_ARTIFACTID="$1"
BUILD_NUMBER="$2"

DOCKER_IMAGE="${POM_ARTIFACTID}:${BUILD_NUMBER}"

sudo docker build -t "${DOCKER_IMAGE}" .
sudo docker tag "${DOCKER_IMAGE}" "${POM_ARTIFACTID}"/latest
sudo docker tag "${DOCKER_IMAGE}" "justinholmes/${POM_ARTIFACTID}"
sudo docker push justinholmes/${POM_ARTIFACTID}
