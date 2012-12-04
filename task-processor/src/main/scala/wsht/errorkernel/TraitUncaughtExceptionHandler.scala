package wsht.errorkernel

import wsht.exception.{NonRecoverableError, TaskExpiredFault}

trait TraitUncaughtExceptionHandler { 

  def noRecoverableError(e: NonRecoverableError): Throwable

  def taskExpiredFault(e: TaskExpiredFault): Throwable

}