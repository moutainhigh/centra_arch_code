1.������
gradle build -x test
2.���ɾ���
�ڱ������ɾ���
docker build -t rtm:1.0 .
docker build -t 10.1.234.164:5000/billing/rtm:1.0 .
docker push 10.1.234.164:5000/billing/rtm:1.0