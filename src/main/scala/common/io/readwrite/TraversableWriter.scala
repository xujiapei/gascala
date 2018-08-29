package common.io.readwrite



import common.io.ReadWriteFormat.ReadWriteFormat
import common.io.SaveMode.SaveMode
import common.io.readwrite.jdbc.JdbcTraversableReadWriter
import common.io.readwrite.text.TextTraversableReadWriter
import common.io.{ReadWriteConf, ReadWriteFormat, TraversableWriteAble}
import common.scalikejdbc.ScalikejdbcConf
import common.utils.impros._
import common.utils.patterns._

import scala.collection.mutable
import scala.reflect.ClassTag

/**
  * Created by Night on 2018/7/22.
  */
case class TraversableWriter[T: ClassTag](traversableData: Traversable[T], conf: mutable.HashMap[String, String])
  extends UsingPattern {
  implicit def readWriteConf(writerConf: mutable.HashMap[String, String]) = ReadWriteConf(writerConf)
  implicit def jdbcConf(readConf: mutable.HashMap[String, String]) = ScalikejdbcConf(readConf)
  private def traversableWriter(): TraversableWriteAble = conf.outputFormat match {
    case ReadWriteFormat.Text => TextTraversableReadWriter()
    case ReadWriteFormat.Jdbc => JdbcTraversableReadWriter()
    case _ => throw new Throwable("未受支持的 fileFormat 类型");
  }

  /** ********************************   Public   ****************************************/

  def format(chooseFileFormat: ReadWriteFormat) = {
    conf.outputFormat(chooseFileFormat)
    this
  }

  def mode(chooseMode: SaveMode) = {
    conf.outputMode(chooseMode)
    this
  }

  def text(path: String) = {
    this.format(ReadWriteFormat.Text)
    this.conf.outputTextPath(path)
    this.save()
  }

  def jdbc(table:String,driver:String,url:String,user:String,password:String) ={
    this.format(ReadWriteFormat.Jdbc)
    conf.outputJdbcTable(table)
    conf.driver(driver).url(url).user(user).password(password)
    this.save()
  }

  def save() = {
    traversableWriter.save(traversableData, conf);
    this;
  }
}
