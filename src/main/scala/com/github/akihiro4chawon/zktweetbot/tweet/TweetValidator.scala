package com.github.akihiro4chawon.zktweetbot.tweet

import java.util.Date
import org.zkoss.bind.ValidationContext
import org.zkoss.bind.validator.AbstractValidator

class TweetValidator extends AbstractValidator {
  def validate(ctx: ValidationContext) {
    ctx.getProperties("date")(0).getValue() match {
      case _: Date 	=> // okay
      case _ => addInvalidMessage(ctx, "date", "You must specify a date")
    }
    
    ctx.getProperties("status")(0).getValue() match {
      case s: String if s.nonEmpty => // okay
      case _ => addInvalidMessage(ctx, "status", "You must enter a status")
    }
  }
}

