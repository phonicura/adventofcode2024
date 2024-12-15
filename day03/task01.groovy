#!/usr/bin/env groovy

def reader = System.in.newReader()
def line = ''

def input = ''
while ((line = reader.readLine()) != null) {
  input += line
}

def result = input
  .findAll(/mul\([0-9]+,[0-9]+\)/)
  .collect {
    def pair = it.findAll(/[0-9]+/).collect{ it as int }
    return pair[0] * pair[1]
  }.sum()

println(result)
