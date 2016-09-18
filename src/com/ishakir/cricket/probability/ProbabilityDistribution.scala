package com.ishakir.cricket.probability

import scala.util.Random

class ProbabilityDistribution[A](totals: Map[A, Int], random: Random) {
  val values: IndexedSeq[A] = totals.keys.toIndexedSeq
  val boundaries: IndexedSeq[Float] = {
    val sum = totals.values.sum
    totals.values.foldLeft(IndexedSeq[Float](0)) { (acc, value) => acc :+ (acc.last + (value.toFloat / sum)) }
  }

  def sample(): A = {
    val sample = random.nextFloat()
    boundaries.zipWithIndex.zip(boundaries.tail).find { case ((min, index), max) => sample >= min && sample < max } match {
      case Some(((_, index),  _)) => values(index)
      case None => throw new IllegalArgumentException("Why have we ended up with no sample? :(")
    }
  }
}

