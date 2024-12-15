#!/usr/bin/env groovy

def reader = System.in.newReader()
def line = ''

def pairs = []
while ((line = reader.readLine()) != null) {
  def pair = line.split(' +').collect{ it as int }
  pairs.add(pair)
}

def result = pairs
  .transpose().collect{ it.sort() }
  .transpose().collect{ Math.abs(it[0] - it[1]) }
  .sum()

println(result)
