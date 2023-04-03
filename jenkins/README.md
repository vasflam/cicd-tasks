# Jenkins Docker with Nginx as proxy

### Install
```
ssh-keygen -t rsa -b 2048 -f ~/.ssh/jenkins_local
key=$(cat ~/.ssh/jenkins_local.pub)
echo "JENKINS_AGENT_SSH_PUBKEY=${key}" > .agent.env
echo "Private key is:";
cat ~/.ssh/jenkins_local
```
