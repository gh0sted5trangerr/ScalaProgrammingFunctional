enum Wochentag(langform: String):
  case Mo extends Wochentag("Montag")
  case Di extends Wochentag("Dienstag")
  case Mi extends Wochentag("Mittwoch")
  case Do extends Wochentag("Donnerstag")
  case Fr extends Wochentag("Freitag")
  case Sa extends Wochentag("Samstag")
  case So extends Wochentag("Sonntag")
Wochentag.values

def naesterTag(day: Wochentag) : Wochentag = {
  Wochentag.fromOrdinal((day.ordinal+1) %7)
}
naesterTag(Wochentag.So)