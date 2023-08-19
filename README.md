# Orders-Processor

# INTRODUCTION

This program will process a set of files (e.g., example1.txt (sampleFiles/example1.txt)) each representing a purchase order. Each file lists the items bought and the date of purchase. The possible items that can be purchased (along with the item's price) can be found in a item's data file (e.g., itemsData.txt (sampleFiles/itemsData.txt)). The program will generate a summary for each order (file). The summary includes the client id and a sorted list (by item's name) of each item bought. The list will include the item's name, the cost per item, the quantity of items bought, and the total cost associated with the item's purchase. After the sorted list, an order's total will be displayed. See Example 1. 

In addition to a report for each order, the program will generate a summary of all orders. The summary will display a sorted list (by item's name) providing information about the total number of items sold, and total revenue. See Example 1. 

This program will allow users to process all the orders using a single thread or one thread per order (file).
