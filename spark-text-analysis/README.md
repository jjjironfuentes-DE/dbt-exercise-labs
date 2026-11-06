# Napoleon Hill - Text Analysis with Apache Spark

## Project Overview

This project analyzes the text data from Napoleon Hill
using Apache Spark and Scala.

The objective is to process textual data, clean the content,
remove stopwords and identify the most frequent words.

## Technologies

- Apache Spark
- Scala
- CSV
- Natural Language Processing (NLP)
- NLTK Stopwords

## Project Structure

```text
spark-text-analysis/
├── data/
│   ├── Napoleon_Hill(1).csv
│   └── nltk_stopwords/
├── results/
│   ├── spark_shell_session.txt
│   └── top5.txt
├── src/
│   └── word_count_session.scala
└── README.md
