This document represents my opinion on the current state of 
Test automation for Loyalty test auto repositories

Multi Tender Functional tests
Customer Value

My observations reinforce a perspective: The former test automaiton vision has drifted off course
Your comment about the test cases becoming a aggragation does describe the way the vision and direction has drifted.

The name of the repo is Multi Tender Functional tests.  It seems clear from test scripting this is the direction initially taken.
But, with the addition of Multi Tender Loyalty program, there as been code added that brings existing work into the Multi Tender Loyalty world.
This act begins to cloud the vision of the original Functional tests. With the addition of the end to end nature of MT Loyalty the functional tests become nearly hidden.

We do need a breakdown of the collection of testing.  
We also need end to end test cases, maybe just as many as we have now, but we dont want to loose the functional tests in the process.
Each repository should also have some level of documentation that explains details as some agreed upon level.  


Documentation

54 Test Script
420 Scenarios
3458 Steps

File naming pattern that is being used 
user_online_thin_return_transaction_all_brand_1##,  *_2##, up to 4, etc.
user_stores_transaction_ON_brand_1##, *_2##, 



So, what do we have.
we have a lot of tests.  We have little or no documentation ( that I've seen ) that would explain vision, direction and current status.

   * Initially scripting is broken out by Functionality.  So, what are the functions:  Is there a list ?

   * Due to dedicatd effort have we have ended up not knowing how much of what we have, nor how similar or different it is.

   * At some point the test cases start getting really big as if they were end to end TC

   * Over time, we are treating the functional operation as a means ot activiating the loyalty system points calculation.
      * Means no longer focusing on testing the functional operation

   * We have a very larg problem of clean non changing test data. Epsilon 


Put the whiney crap here
==========================================================================================================================================================

   * With so many similarly named files and no map / legend, we really dont know how much of what we have, nor how similar named items differ.

   * At some point the test cases start getting really big as if they were end to end TC
      * As an E2E Tc they needed to cancel several items in on purchase order.  So the order needed to have many items
      * we are no longer testing the cancel or return function. We are treating the cancel operation as a means ot activiating the loyalty system points calculation.

   * We have a very larg problem of clean non changing test data. Epsilon 
      * Clean means the data doesn't change.  Even after a test run, you can reset and get back to what you had, and what the TC is written to expect 
      * If we need to have aged data, we need to isolated the data and the tests that expect that to happen.



What do we need

We need to know what we have 

we need to know what it does

We need to know how to control test data

We need to break apart what has been clumped together in order to rescue the important Functional tests.

We Do not need to delete what has become end to end testing.  But we need to seperate it from functional, acceptance,and smoke testing code.

These should not all run together.
