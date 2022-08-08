Design the RESTful web service to handle the following requests:
- List all the available source and destination cities
  List all the available source and destination airports
  List the airports within a city
  List the inbound schedule for an airport: 
    Days of week
    Time of arrival
    Flight no
    Origin
List  the outbound schedule for an airport:
  Days of week
  Time of departure
  Flight no
  Destination
List the routes connecting two points
  Point might be either an airport or a city. In the latter case we should search for  the flights connecting any airports within the city
  The mandatory “departure date” parameter limits the flights by the ones departing between 0:00:00 of the specified date and 0:00:00 of the next date
  The “booking class” parameter should be one of the 'Economy', 'Comfort', 'Business'
  Additional parameter limits the number of connections: 0 (direct), 1, 2, 3, unbound
Create a booking for a selected route for a single passenger
Online check-in for a flight
