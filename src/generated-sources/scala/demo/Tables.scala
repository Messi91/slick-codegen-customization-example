package demo
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.driver.H2Driver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.driver.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Array(coffeeDescriptions.schema, coffeeHouses.schema, coffeeInventory.schema, coffees.schema, dataRepository.schema, merchInventory.schema, message.schema, rssFeeds.schema, suppliers.schema).reduceLeft(_ ++ _)
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table coffeeDescriptions
   *  @param cofName Database column COF_NAME SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param cofDesc Database column COF_DESC SqlType(BLOB) */
  case class CoffeeDescriptionsRow(cofName: String, cofDesc: java.sql.Blob)
  /** GetResult implicit for fetching CoffeeDescriptionsRow objects using plain SQL queries */
  implicit def GetResultCoffeeDescriptionsRow(implicit e0: GR[String], e1: GR[java.sql.Blob]): GR[CoffeeDescriptionsRow] = GR{
    prs => import prs._
    CoffeeDescriptionsRow.tupled((<<[String], <<[java.sql.Blob]))
  }
  /** Table description of table COFFEE_DESCRIPTIONS. Objects of this class serve as prototypes for rows in queries. */
  class CoffeeDescriptions(_tableTag: Tag) extends Table[CoffeeDescriptionsRow](_tableTag, "COFFEE_DESCRIPTIONS") {
    def * = (cofName, cofDesc) <> (CoffeeDescriptionsRow.tupled, CoffeeDescriptionsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(cofName), Rep.Some(cofDesc)).shaped.<>({r=>import r._; _1.map(_=> CoffeeDescriptionsRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column COF_NAME SqlType(VARCHAR), PrimaryKey, Length(32,true) */
    val cofName: Rep[String] = column[String]("COF_NAME", O.PrimaryKey, O.Length(32,varying=true))
    /** Database column COF_DESC SqlType(BLOB) */
    val cofDesc: Rep[java.sql.Blob] = column[java.sql.Blob]("COF_DESC")

    /** Foreign key referencing coffees (database name CONSTRAINT_EC) */
    lazy val coffeesFk = foreignKey("CONSTRAINT_EC", cofName, coffees)(r => r.name, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
  }
  /** Collection-like TableQuery object for table coffeeDescriptions */
  lazy val coffeeDescriptions = new TableQuery(tag => new CoffeeDescriptions(tag))

  /** Entity class storing rows of table coffeeHouses
   *  @param storeId Database column STORE_ID SqlType(INTEGER), PrimaryKey
   *  @param city Database column CITY SqlType(VARCHAR), Length(32,true)
   *  @param coffee Database column COFFEE SqlType(INTEGER)
   *  @param merch Database column MERCH SqlType(INTEGER)
   *  @param total Database column TOTAL SqlType(INTEGER) */
  case class CoffeeHousesRow(storeId: Int, city: Option[String], coffee: Int, merch: Int, total: Int)
  /** GetResult implicit for fetching CoffeeHousesRow objects using plain SQL queries */
  implicit def GetResultCoffeeHousesRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[CoffeeHousesRow] = GR{
    prs => import prs._
    CoffeeHousesRow.tupled((<<[Int], <<?[String], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table COFFEE_HOUSES. Objects of this class serve as prototypes for rows in queries. */
  class CoffeeHouses(_tableTag: Tag) extends Table[CoffeeHousesRow](_tableTag, "COFFEE_HOUSES") {
    def * = (storeId, city, coffee, merch, total) <> (CoffeeHousesRow.tupled, CoffeeHousesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(storeId), city, Rep.Some(coffee), Rep.Some(merch), Rep.Some(total)).shaped.<>({r=>import r._; _1.map(_=> CoffeeHousesRow.tupled((_1.get, _2, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column STORE_ID SqlType(INTEGER), PrimaryKey */
    val storeId: Rep[Int] = column[Int]("STORE_ID", O.PrimaryKey)
    /** Database column CITY SqlType(VARCHAR), Length(32,true) */
    val city: Rep[Option[String]] = column[Option[String]]("CITY", O.Length(32,varying=true))
    /** Database column COFFEE SqlType(INTEGER) */
    val coffee: Rep[Int] = column[Int]("COFFEE")
    /** Database column MERCH SqlType(INTEGER) */
    val merch: Rep[Int] = column[Int]("MERCH")
    /** Database column TOTAL SqlType(INTEGER) */
    val total: Rep[Int] = column[Int]("TOTAL")
  }
  /** Collection-like TableQuery object for table coffeeHouses */
  lazy val coffeeHouses = new TableQuery(tag => new CoffeeHouses(tag))

  /** Entity class storing rows of table coffeeInventory
   *  @param warehouseId Database column WAREHOUSE_ID SqlType(INTEGER)
   *  @param coffeeName Database column COF_NAME SqlType(VARCHAR), Length(32,true)
   *  @param supId Database column SUP_ID SqlType(INTEGER)
   *  @param quantity Database column QUAN SqlType(INTEGER)
   *  @param dateVal Database column DATE_VAL SqlType(TIMESTAMP) */
  case class CoffeeInventoryItem(warehouseId: Int, coffeeName: String, supId: Int, quantity: Int, dateVal: Option[java.sql.Timestamp])
  /** GetResult implicit for fetching CoffeeInventoryItem objects using plain SQL queries */
  implicit def GetResultCoffeeInventoryItem(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[java.sql.Timestamp]]): GR[CoffeeInventoryItem] = GR{
    prs => import prs._
    CoffeeInventoryItem.tupled((<<[Int], <<[String], <<[Int], <<[Int], <<?[java.sql.Timestamp]))
  }
  /** Table description of table COF_INVENTORY. Objects of this class serve as prototypes for rows in queries. */
  class CoffeeInventory(_tableTag: Tag) extends Table[CoffeeInventoryItem](_tableTag, "COF_INVENTORY") {
    def * = (warehouseId, coffeeName, supId, quantity, dateVal) <> (CoffeeInventoryItem.tupled, CoffeeInventoryItem.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(warehouseId), Rep.Some(coffeeName), Rep.Some(supId), Rep.Some(quantity), dateVal).shaped.<>({r=>import r._; _1.map(_=> CoffeeInventoryItem.tupled((_1.get, _2.get, _3.get, _4.get, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column WAREHOUSE_ID SqlType(INTEGER) */
    val warehouseId: Rep[Int] = column[Int]("WAREHOUSE_ID")
    /** Database column COF_NAME SqlType(VARCHAR), Length(32,true) */
    val coffeeName: Rep[String] = column[String]("COF_NAME", O.Length(32,varying=true))
    /** Database column SUP_ID SqlType(INTEGER) */
    val supId: Rep[Int] = column[Int]("SUP_ID")
    /** Database column QUAN SqlType(INTEGER) */
    val quantity: Rep[Int] = column[Int]("QUAN")
    /** Database column DATE_VAL SqlType(TIMESTAMP) */
    val dateVal: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("DATE_VAL")

    /** Foreign key referencing coffees (database name CONSTRAINT_5) */
    lazy val coffeesFk = foreignKey("CONSTRAINT_5", coffeeName, coffees)(r => r.name, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
    /** Foreign key referencing suppliers (database name CONSTRAINT_57) */
    lazy val suppliersFk = foreignKey("CONSTRAINT_57", supId, suppliers)(r => r.id, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
  }
  /** Collection-like TableQuery object for table coffeeInventory */
  lazy val coffeeInventory = new TableQuery(tag => new CoffeeInventory(tag))

  /** Entity class storing rows of table coffees
   *  @param name Database column COF_NAME SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param supplierId Database column SUP_ID SqlType(INTEGER)
   *  @param price Database column PRICE SqlType(DECIMAL)
   *  @param sales Database column SALES SqlType(INTEGER)
   *  @param total Database column TOTAL SqlType(INTEGER) */
  case class Coffee(name: String, supplierId: Int, price: scala.math.BigDecimal, sales: Int, total: Int)
  /** GetResult implicit for fetching Coffee objects using plain SQL queries */
  implicit def GetResultCoffee(implicit e0: GR[String], e1: GR[Int], e2: GR[scala.math.BigDecimal]): GR[Coffee] = GR{
    prs => import prs._
    Coffee.tupled((<<[String], <<[Int], <<[scala.math.BigDecimal], <<[Int], <<[Int]))
  }
  /** Table description of table COFFEES. Objects of this class serve as prototypes for rows in queries. */
  class Coffees(_tableTag: Tag) extends Table[Coffee](_tableTag, "COFFEES") {
    def * = (name, supplierId, price, sales, total) <> (Coffee.tupled, Coffee.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(name), Rep.Some(supplierId), Rep.Some(price), Rep.Some(sales), Rep.Some(total)).shaped.<>({r=>import r._; _1.map(_=> Coffee.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column COF_NAME SqlType(VARCHAR), PrimaryKey, Length(32,true) */
    val name: Rep[String] = column[String]("COF_NAME", O.PrimaryKey, O.Length(32,varying=true))
    /** Database column SUP_ID SqlType(INTEGER) */
    val supplierId: Rep[Int] = column[Int]("SUP_ID")
    /** Database column PRICE SqlType(DECIMAL) */
    val price: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("PRICE")
    /** Database column SALES SqlType(INTEGER) */
    val sales: Rep[Int] = column[Int]("SALES")
    /** Database column TOTAL SqlType(INTEGER) */
    val total: Rep[Int] = column[Int]("TOTAL")

    /** Foreign key referencing suppliers (database name CONSTRAINT_63) */
    lazy val suppliersFk = foreignKey("CONSTRAINT_63", supplierId, suppliers)(r => r.id, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
  }
  /** Collection-like TableQuery object for table coffees */
  lazy val coffees = new TableQuery(tag => new Coffees(tag))

  /** Entity class storing rows of table dataRepository
   *  @param documentName Database column DOCUMENT_NAME SqlType(VARCHAR), Length(50,true)
   *  @param url Database column URL SqlType(VARCHAR), Length(200,true) */
  case class DataRepositoryRow(documentName: Option[String], url: Option[String])
  /** GetResult implicit for fetching DataRepositoryRow objects using plain SQL queries */
  implicit def GetResultDataRepositoryRow(implicit e0: GR[Option[String]]): GR[DataRepositoryRow] = GR{
    prs => import prs._
    DataRepositoryRow.tupled((<<?[String], <<?[String]))
  }
  /** Table description of table DATA_REPOSITORY. Objects of this class serve as prototypes for rows in queries. */
  class DataRepository(_tableTag: Tag) extends Table[DataRepositoryRow](_tableTag, "DATA_REPOSITORY") {
    def * = (documentName, url) <> (DataRepositoryRow.tupled, DataRepositoryRow.unapply)

    /** Database column DOCUMENT_NAME SqlType(VARCHAR), Length(50,true) */
    val documentName: Rep[Option[String]] = column[Option[String]]("DOCUMENT_NAME", O.Length(50,varying=true))
    /** Database column URL SqlType(VARCHAR), Length(200,true) */
    val url: Rep[Option[String]] = column[Option[String]]("URL", O.Length(200,varying=true))
  }
  /** Collection-like TableQuery object for table dataRepository */
  lazy val dataRepository = new TableQuery(tag => new DataRepository(tag))

  /** Entity class storing rows of table merchInventory
   *  @param itemId Database column ITEM_ID SqlType(INTEGER), PrimaryKey
   *  @param itemName Database column ITEM_NAME SqlType(VARCHAR), Length(20,true)
   *  @param supId Database column SUP_ID SqlType(INTEGER)
   *  @param quan Database column QUAN SqlType(INTEGER)
   *  @param dateVal Database column DATE_VAL SqlType(TIMESTAMP) */
  case class MerchInventoryRow(itemId: Int, itemName: Option[String], supId: Option[Int], quan: Option[Int], dateVal: Option[java.sql.Timestamp])
  /** GetResult implicit for fetching MerchInventoryRow objects using plain SQL queries */
  implicit def GetResultMerchInventoryRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Option[java.sql.Timestamp]]): GR[MerchInventoryRow] = GR{
    prs => import prs._
    MerchInventoryRow.tupled((<<[Int], <<?[String], <<?[Int], <<?[Int], <<?[java.sql.Timestamp]))
  }
  /** Table description of table MERCH_INVENTORY. Objects of this class serve as prototypes for rows in queries. */
  class MerchInventory(_tableTag: Tag) extends Table[MerchInventoryRow](_tableTag, "MERCH_INVENTORY") {
    def * = (itemId, itemName, supId, quan, dateVal) <> (MerchInventoryRow.tupled, MerchInventoryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(itemId), itemName, supId, quan, dateVal).shaped.<>({r=>import r._; _1.map(_=> MerchInventoryRow.tupled((_1.get, _2, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ITEM_ID SqlType(INTEGER), PrimaryKey */
    val itemId: Rep[Int] = column[Int]("ITEM_ID", O.PrimaryKey)
    /** Database column ITEM_NAME SqlType(VARCHAR), Length(20,true) */
    val itemName: Rep[Option[String]] = column[Option[String]]("ITEM_NAME", O.Length(20,varying=true))
    /** Database column SUP_ID SqlType(INTEGER) */
    val supId: Rep[Option[Int]] = column[Option[Int]]("SUP_ID")
    /** Database column QUAN SqlType(INTEGER) */
    val quan: Rep[Option[Int]] = column[Option[Int]]("QUAN")
    /** Database column DATE_VAL SqlType(TIMESTAMP) */
    val dateVal: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("DATE_VAL")

    /** Foreign key referencing suppliers (database name CONSTRAINT_678) */
    lazy val suppliersFk = foreignKey("CONSTRAINT_678", supId, suppliers)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
  }
  /** Collection-like TableQuery object for table merchInventory */
  lazy val merchInventory = new TableQuery(tag => new MerchInventory(tag))

  /** Entity class storing rows of table message
   *  @param id Database column ID SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param uuid Database column UUID SqlType(VARCHAR), Length(36,true)
   *  @param sender Database column SENDER SqlType(VARCHAR), Length(256,true)
   *  @param content Database column CONTENT SqlType(VARCHAR), Length(2000,true) */
  case class MessageRow(id: Long, uuid: Option[String], sender: String, content: String)
  /** GetResult implicit for fetching MessageRow objects using plain SQL queries */
  implicit def GetResultMessageRow(implicit e0: GR[Long], e1: GR[Option[String]], e2: GR[String]): GR[MessageRow] = GR{
    prs => import prs._
    MessageRow.tupled((<<[Long], <<?[String], <<[String], <<[String]))
  }
  /** Table description of table MESSAGE. Objects of this class serve as prototypes for rows in queries. */
  class Message(_tableTag: Tag) extends Table[MessageRow](_tableTag, "MESSAGE") {
    def * = (id, uuid, sender, content) <> (MessageRow.tupled, MessageRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), uuid, Rep.Some(sender), Rep.Some(content)).shaped.<>({r=>import r._; _1.map(_=> MessageRow.tupled((_1.get, _2, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("ID", O.AutoInc, O.PrimaryKey)
    /** Database column UUID SqlType(VARCHAR), Length(36,true) */
    val uuid: Rep[Option[String]] = column[Option[String]]("UUID", O.Length(36,varying=true))
    /** Database column SENDER SqlType(VARCHAR), Length(256,true) */
    val sender: Rep[String] = column[String]("SENDER", O.Length(256,varying=true))
    /** Database column CONTENT SqlType(VARCHAR), Length(2000,true) */
    val content: Rep[String] = column[String]("CONTENT", O.Length(2000,varying=true))

    /** Uniqueness Index over (uuid) (database name CONSTRAINT_INDEX_63) */
    val index1 = index("CONSTRAINT_INDEX_63", uuid, unique=true)
  }
  /** Collection-like TableQuery object for table message */
  lazy val message = new TableQuery(tag => new Message(tag))

  /** Entity class storing rows of table rssFeeds
   *  @param rssName Database column RSS_NAME SqlType(VARCHAR), PrimaryKey, Length(32,true)
   *  @param rssFeedXml Database column RSS_FEED_XML SqlType(CLOB) */
  case class RssFeedsRow(rssName: String, rssFeedXml: java.sql.Clob)
  /** GetResult implicit for fetching RssFeedsRow objects using plain SQL queries */
  implicit def GetResultRssFeedsRow(implicit e0: GR[String], e1: GR[java.sql.Clob]): GR[RssFeedsRow] = GR{
    prs => import prs._
    RssFeedsRow.tupled((<<[String], <<[java.sql.Clob]))
  }
  /** Table description of table RSS_FEEDS. Objects of this class serve as prototypes for rows in queries. */
  class RssFeeds(_tableTag: Tag) extends Table[RssFeedsRow](_tableTag, "RSS_FEEDS") {
    def * = (rssName, rssFeedXml) <> (RssFeedsRow.tupled, RssFeedsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(rssName), Rep.Some(rssFeedXml)).shaped.<>({r=>import r._; _1.map(_=> RssFeedsRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column RSS_NAME SqlType(VARCHAR), PrimaryKey, Length(32,true) */
    val rssName: Rep[String] = column[String]("RSS_NAME", O.PrimaryKey, O.Length(32,varying=true))
    /** Database column RSS_FEED_XML SqlType(CLOB) */
    val rssFeedXml: Rep[java.sql.Clob] = column[java.sql.Clob]("RSS_FEED_XML")
  }
  /** Collection-like TableQuery object for table rssFeeds */
  lazy val rssFeeds = new TableQuery(tag => new RssFeeds(tag))

  /** Entity class storing rows of table suppliers
   *  @param id Database column SUP_ID SqlType(INTEGER), AutoInc, PrimaryKey
   *  @param name Database column SUP_NAME SqlType(VARCHAR), Length(40,true)
   *  @param street Database column STREET SqlType(VARCHAR), Length(40,true)
   *  @param city Database column CITY SqlType(VARCHAR), Length(20,true)
   *  @param state Database column STATE SqlType(CHAR), Length(2,false)
   *  @param zip Database column ZIP SqlType(CHAR), Length(5,false) */
  case class Supplier(id: Int, name: String, street: String, city: String, state: String, zip: Option[String])
  /** GetResult implicit for fetching Supplier objects using plain SQL queries */
  implicit def GetResultSupplier(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]]): GR[Supplier] = GR{
    prs => import prs._
    Supplier.tupled((<<[Int], <<[String], <<[String], <<[String], <<[String], <<?[String]))
  }
  /** Table description of table SUPPLIERS. Objects of this class serve as prototypes for rows in queries. */
  class Suppliers(_tableTag: Tag) extends Table[Supplier](_tableTag, "SUPPLIERS") {
    def * = (id, name, street, city, state, zip) <> (Supplier.tupled, Supplier.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name), Rep.Some(street), Rep.Some(city), Rep.Some(state), zip).shaped.<>({r=>import r._; _1.map(_=> Supplier.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column SUP_ID SqlType(INTEGER), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("SUP_ID", O.AutoInc, O.PrimaryKey)
    /** Database column SUP_NAME SqlType(VARCHAR), Length(40,true) */
    val name: Rep[String] = column[String]("SUP_NAME", O.Length(40,varying=true))
    /** Database column STREET SqlType(VARCHAR), Length(40,true) */
    val street: Rep[String] = column[String]("STREET", O.Length(40,varying=true))
    /** Database column CITY SqlType(VARCHAR), Length(20,true) */
    val city: Rep[String] = column[String]("CITY", O.Length(20,varying=true))
    /** Database column STATE SqlType(CHAR), Length(2,false) */
    val state: Rep[String] = column[String]("STATE", O.Length(2,varying=false))
    /** Database column ZIP SqlType(CHAR), Length(5,false) */
    val zip: Rep[Option[String]] = column[Option[String]]("ZIP", O.Length(5,varying=false))
  }
  /** Collection-like TableQuery object for table suppliers */
  lazy val suppliers = new TableQuery(tag => new Suppliers(tag))
}
