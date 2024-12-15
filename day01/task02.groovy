#!/usr/bin/env groovy

def reader = System.in.newReader()
def line = ''

def pairs = []
while ((line = reader.readLine()) != null) {
  def pair = line.split(' +').collect{ it as int }
  pairs.add(pair)
}

def lists = pairs.transpose().collect{ it.sort() }

def result = lists[0]
  .collect{ it * lists[1].count(it) }
  .sum()

println(result)
