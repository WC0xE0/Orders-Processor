# Orders-Processor

# INTRODUCTION

This program will process a set of files (e.g., example1.txt (sampleFiles/example1.txt)) each representing a purchase order. Each file lists the items bought and the date of purchase. The possible items that can be purchased (along with the item's price) can be found in a item's data file (e.g., itemsData.txt (sampleFiles/itemsData.txt)). The program will generate a summary for each order (file). The summary includes the client id and a sorted list (by item's name) of each item bought. The list will include the item's name, the cost per item, the quantity of items bought, and the total cost associated with the item's purchase. After the sorted list, an order's total will be displayed. See Example 1. 

In addition to a report for each order, the program will generate a summary of all orders. The summary will display a sorted list (by item's name) providing information about the total number of items sold, and total revenue. See Example 1. 

This program will allow users to process all the orders using a single thread or one thread per order (file).


## Example 1
----- Order details for client with Id: 1001 ----- \\
Item's name: Blu-Ray, Cost per item: $15.00, Quantity: 2, Cost: $30.00 \\
Item's name: Lamp, Cost per item: $3.50, Quantity: 1, Cost: $3.50 \\
Item's name: Phone, Cost per item: $13.75, Quantity: 2, Cost: $27.50 \\
Item's name: Shoes, Cost per item: $30.00, Quantity: 1, Cost: $30.00 \\
Item's name: Song, Cost per item: $2.00, Quantity: 1, Cost: $2.00 \\
Order Total: $93.00 \\
----- Order details for client with Id: 1002 -----
Item's name: MovieRental, Cost per item: $4.00, Quantity: 1, Cost: $4.00
Item's name: Phone, Cost per item: $13.75, Quantity: 1, Cost: $13.75
Item's name: Shoes, Cost per item: $30.00, Quantity: 2, Cost: $60.00
Item's name: Song, Cost per item: $2.00, Quantity: 3, Cost: $6.00
Item's name: Textbook, Cost per item: $25.00, Quantity: 1, Cost: $25.00
Order Total: $108.75
----- Order details for client with Id: 1003 -----
Item's name: Lamp, Cost per item: $3.50, Quantity: 2, Cost: $7.00
Item's name: MovieRental, Cost per item: $4.00, Quantity: 1, Cost: $4.00
Item's name: Phone, Cost per item: $13.75, Quantity: 2, Cost: $27.50
Order Total: $38.50
***** Summary of all orders *****
Summary - Item's name: Blu-Ray, Cost per item: $15.00, Number sold: 2, Item's Total: $30.00
Summary - Item's name: Lamp, Cost per item: $3.50, Number sold: 3, Item's Total: $10.50
Summary - Item's name: MovieRental, Cost per item: $4.00, Number sold: 2, Item's Total: $8.00
Summary - Item's name: Phone, Cost per item: $13.75, Number sold: 5, Item's Total: $68.75
Summary - Item's name: Shoes, Cost per item: $30.00, Number sold: 3, Item's Total: $90.00
Summary - Item's name: Song, Cost per item: $2.00, Number sold: 4, Item's Total: $8.00
Summary - Item's name: Textbook, Cost per item: $25.00, Number sold: 1, Item's Total: $25.00
Summary Grand Total: $240.25

