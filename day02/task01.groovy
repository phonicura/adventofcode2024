#!/usr/bin/env groovy

boolean isSafe(List<Integer> report) {
  def reportSorted = report.sort(false)

  // Check for double values
  if (report != report.unique()) {
    return false
  }

  // Check if list is sorted
  if (![reportSorted, reportSorted.reverse()].contains(report)) {
    return false
  }

  // Check for max distance
  def maxDistance = [report, report.subList(1, report.size())]
    .transpose()
    .collect{ Math.abs(it[0] - it[1]) }
    .max()

  return maxDistance <= 3
}

def reader = System.in.newReader()
def line = ''

def reports = []
while ((line = reader.readLine()) != null) {
  def report = line.split(' +').collect{ it as Integer }
  reports.add(report)
}

def result = reports
  .collect { isSafe(it) }
  .collect{ it.compareTo(false) }
  .sum()

println(result)
