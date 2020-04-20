LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (1,'Department_1'),(2,'Department_2'),(3,'Department_3');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Employee_1',_binary '',1),(2,'Employee_2',_binary '',1),(3,'Employee_3',_binary '\0',1),(4,'Employee_4',_binary '\0',3),(5,'Employee_5',_binary '\0',2),(6,'Employee_6',_binary '\0',2),(7,'Employee_7',_binary '',1),(8,'Employee_8',_binary '',3),(9,'Employee_9',_binary '',2),(10,'Employee_10',_binary '',1),(11,'Employee_11',_binary '',1),(12,'Employee_12',_binary '\0',1),(13,'Employee_13',_binary '\0',3),(14,'Employee_14',_binary '\0',2),(15,'Employee_15',_binary '\0',2),(16,'Employee_16',_binary '',1),(17,'Employee_17',_binary '',3),(18,'Employee_18',_binary '',2),(19,'Employee_19',_binary '',1),(20,'Employee_20',_binary '\0',1),(21,'Employee_21',_binary '\0',3),(22,'Employee_22',_binary '\0',2),(23,'Employee_23',_binary '\0',2),(24,'Employee_24',_binary '',1),(25,'Employee_25',_binary '',3),(26,'Employee_26',_binary '',2);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','$2a$10$TYDzuWyh4cKXQtDKN8JvBuE3b9thcEw13li15DyG5mRpgCcyfD3tq');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
