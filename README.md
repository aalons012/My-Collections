# My-Collections
This is a part of my Collection of some of my Consoles &amp; Games from my Consoles/PC

# Version 1
The first version of Andy Collection is an Android app that displays my favorite items using three activities. The Main Activity shows general information about the collection, an image, and buttons with colors that let the user navigate to the collection list. The List Activity displays at least five items from the collection, and tapping an item opens the Details Activity, which shows more information about that specific item and includes a button to go back to the list. All items are stored directly in the code, and there is no persistent storage or Room database in this version.
# Version 2
Version 2 of Andy Collection adds persistent storage using the Room libraries. The collection class was converted into a Room entity, a DAO and database were implemented, and the app now pre-populates the database with several items at startup. The Main Activity, Collection List Activity, and Details Activity still provide the same navigation and UI, but the items are now loaded from the Room database instead of being defined directly in code, similar to the Book Study Helper example.
