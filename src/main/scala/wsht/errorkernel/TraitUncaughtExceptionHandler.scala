package wsht.errorkernel

import wsht.exception.{NonRecoverableError, TaskExpiredFault}

trait TraitUncaughtExceptionHandler { 

  def noRecoverableError(e: NonRecoverableError): Boolean

  def taskExpiredFault(e: TaskExpiredFault): Boolean

}