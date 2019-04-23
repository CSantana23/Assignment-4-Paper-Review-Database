#Add data to AUTHOR table

INSERT INTO Author (EmailAddr, FirstName, LastName) 
VALUES 
('caronni@mac.com','Alica','Caronni'),
('matsn@comcast.net','Sterling','Matthew'),
('bebing@aol.com','Bebosta','William'),
('Storerm@yahoo.ca','Storer','Johnny'),
('Brainless@outlook.com','Peyton','Claus'),
('markjugg@hotmail.com','Gleason','Kevin'),


#Add data to PAPER table
INSERT INTO Papers (Title, Abstract, FileName) 
VALUES 
('Learn How To Start SCIENCE',"Let us say that you are 34 years old and a perfectly good adult who draws a complete blank when wondering what science and research are all about.  Even though you passed all the required science courses in school, you view scientific research as something of no concern to you, and scientists as weird creatures from another planet.",'science.pdf'),

('The GLASS That Wins Customers', "Growing and retaining your current customers is smart business. Companies that focus on and strive to delight their customers outperform in the marketplace", 'glassideas.pdf'),

('NEW YORK Iphone Apps',"The busy nature of the city requires a high degree of technical needs in order to keep up with the most detailed information such as the arrival time of the next subway, the nearest eateries, nearest public restroom, fastest route to a particular destination.",'nyc.pdf'),

('WATER Your Way To Success',"There are a few ways you can judge whether you are hydrated enough. If your urine is clear or pale yellow, you’re set. You can also measure it by drinking as much water as it takes to keep your lips and mouth moist throughout the day.",'successfuls.pdf'),

('How To Start A Business With PHYSICS',"Some physicists can be thankful for the overall health and vitality of physics that some brave souls do risk their money and careers by setting up businesses to commercialize their findings.",'businessideas.pdf'),

('Get The Most Out of ECONOMY and Facebook',"I have been in school, learning the Facebook Platform for about two years - almost from the group's inception. My experience has been educational, and personally rewarding. The group has been one of the best associations I have been involved in during my professional life.",'econ.pdf');

#Add data to REVIEWER table

INSERT INTO Reviewer (EmailAddr, FirstName, LastNAme, AuthorFeedback, CommiteeFeedback, PhoneNum, Affiliation) 
VALUES
('jscott@mercy.edu','Scott','James',"This was very good.","Decent read. Okay at best.",'902-435-0985','JGR');
('msklp@yahoo.com','Frank','Castilla',"It was to long.","The paper was not very clear. Needs revision. This is great",'908-837-9032','SLIKE'),
('throms@gmail.com','John','Locke',"Maybe a different topic.","I enjoyed this paper. This is great",'879-435-2352','WPPP'),
('strev@outlook.com','Edwin','Stevonsjp',"Minor changes but good overall.","Everything is okay.",'832-784-9087','PLGR');
('Kiplo@hotmal.com','Luistra','Thomas',"Best Paper I've read.","Very insightful.",'807-467-7823','KNOP'),
('tiredaswell@gmail.com','Walker','Susan',"Great topic to write on.","Might have a chance to be published.",'647-324-8976','YULK');

#Add data to REVIEW table

INSERT INTO Review (ReviewerId, MeritScore, ReadabilityScore, OriginalityScore, RelevanceScore, Recommendation, PaperId) 
VALUES
('jscott@mercy.edu', 7, 5, 8, 3,"This was pretty good", 1),
('msklp@yahoo.com', 6, 7, 9, 6,"Very good work", 2),
('throms@gmail.com', 9, 5, 3, 9,"Make some minor changes",3),
('strev@outlook.com', 9, 8, 9, 9,"Fanctastic!",4),
('kiplo@hotmail.com', 9, 7, 3, 6,"okay at best", 6),
('tiredaswell@gmail.com', 7, 8, 4, 2,"Could be better!",5),

#Add data to TOPIC table

INSERT INTO Topic (TopicName) 
VALUES
('Science'),
('Maths'),
('Countries'),
('Physics'),
('Economy'),
('Travelling'),

#Add data to Author_Submits_Paper table

INSERT INTO Author_Submits_Paper (AuthorID, PaperID) VALUES
('caronni@mac.com', 1),
('matsn@comcast.net', 2),
('bebing@aol.com', 3),
('Storerm@yahoo.ca', 4),
('Brainless@outlook.com', 5),
('markjugg@hotmail.com', 6),



#Add data to Paper_Assigned_Reviewer table

INSERT INTO Paper_Assigned_Reviewer (ReviewerID, PaperID) VALUES
('jscott@mercy.edu', 1),
('strev@outlook.com', 4),
('msklp@yahoo.com', 2),
('tiredaswell@gmail.com', 5),
('throms@gmail.com', 3),
('kiplo@hotmail.com', 6);


#Add data to Reviewer_Has_Topic table

INSERT INTO Reviewer_Has_Topic (ReviewerID, TopicID) VALUES
('msklp@yahoo.com', 2),
('jscott@mercy.edu', 1),
('strev@outlook.com', 4),
('kiplo@hotmail.com', 6),
('tiredaswell@gmail.com', 5),
('throms@gmail.com', 3);



#Add data to Reviewer_Submits_Review table

INSERT INTO Reviewer_Submits_Review (ReviewerID, ReviewID) VALUES
('msklp@yahoo.com', 2),
('strev@outlook.com', 4),
('kiplo@hotmail.com', 6),
('throms@gmail.com', 3),
('tiredaswell@gmail.com', 5),
('jscott@mercy.edu', 1);
