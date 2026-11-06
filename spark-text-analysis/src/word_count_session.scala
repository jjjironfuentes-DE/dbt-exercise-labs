spark.version
val article = spark.read
  .option("header", "true")
  .option("inferSchema", "true")
  .csv("data/Napoleon_Hill(1).csv")
article.printSchema()
article.show(5, false)
val textRDD = article.select("text").rdd.map(row => row.getString(0))
textRDD.take(5).foreach(println)
val lowerRDD = textRDD.map(text => text.toLowerCase)
lowerRDD.take(3).foreach(println)
val cleanRDD = lowerRDD.map(text => text.replaceAll("[^a-z\\s]", " "))
cleanRDD.take(5).foreach(println)
val wordsRDD = cleanRDD
  .flatMap(text => text.trim.split("\\s+"))
  .filter(word => word.nonEmpty)
wordsRDD.take(30).foreach(println)
val stopWords = sc.textFile("data/nltk_stopwords/stopwords/english").collect().toSet
stopWords.size
val filteredRDD = wordsRDD.filter(word => !stopWords.contains(word))
filteredRDD.take(30).foreach(println)
val wordPairs = filteredRDD.map(word => (word, 1))
val wordCounts = wordPairs.reduceByKey((a, b) => a + b)
wordCounts.take(10).foreach(println)
val top5 = wordCounts.sortBy {
  case (word, count) => (-count, word)
}.take(5)
top5.foreach(println)
