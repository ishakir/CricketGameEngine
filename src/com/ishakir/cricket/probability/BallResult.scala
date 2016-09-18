package com.ishakir.cricket.probability

sealed trait BallResult

case object DotBall extends BallResult

class Runs(runs: Int) extends BallResult
case object One extends Runs(1)
case object Two extends Runs(2)
case object Three extends Runs(3)
case object Four extends Runs(4)
case object Six extends Runs(6)

class Extras(extraRuns: Int) extends BallResult

abstract class Byes(extraRuns: Int) extends Extras(extraRuns)
case object OneBye extends Byes(1)
case object TwoByes extends Byes(2)
case object ThreeByes extends Byes(3)
case object FourByes extends Byes(4)

abstract class LegByes(extraRuns: Int) extends Extras(extraRuns)
case object OneLegBye extends LegByes(1)
case object TwoLegByes extends LegByes(2)
case object ThreeLegByes extends LegByes(3)
case object FourLegByes extends LegByes(4)