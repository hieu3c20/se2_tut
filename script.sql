create database se2_studentmanagement;

use se2_studentmanagement;

select * from employee;

INSERT INTO employee (name, age, image, address) 
VALUES ('Hieu', 22, 'hiu.jpg', 'Nam Dinh - Viet Nam');

INSERT INTO employee (name, age, image, address)
VALUES ('Hai', 22, 'janesmith.jpg', 'Ha Noi - Viet Nam');

INSERT INTO employee (name, age, image, address)
VALUES ('Vu', 42, 'michaeljohnson.jpg', '789 Elm St, Elsewhere NY');

UPDATE employee
SET image = 'https://img.freepik.com/free-photo/blue-water-beaches-verona-gorgeous-mountains_8353-7394.jpg?t=st=1716520991~exp=1716524591~hmac=9610e8b8dd828f60c4a6dcf16def86a71f4c4bd0fd87e3701ba2f57d93de5088&w=1060'
where name = 'hieu';

Update employee 
set image="https://img.freepik.com/free-vector/monochromatic-outline-landmarks-skyline-design_23-2148417170.jpg?w=1060&t=st=1716521051~exp=1716521651~hmac=1d3feb4d68f71c263b4b336e105b1f47712c87aeb22034f038e3d5991d02514f"
where name = "hai";

update employee 
set image="https://img.freepik.com/free-photo/cityscape-rome-ancient-centre-italy_1268-20482.jpg?w=1380&t=st=1716521097~exp=1716521697~hmac=8dabdcb8d74a479e6c50664bcb6af3ccd21ddc37d66897bf95e19efdc5e8865a"
where name = "vu";

ALTER TABLE employee MODIFY COLUMN image VARCHAR(5000);

INSERT INTO company (name, image, address) VALUES
  ('Apple Inc.', 'apple.jpg', '1 Infinite Loop, Cupertino, CA 95014'),
  ('Google LLC', 'google.jpg', '1600 Amphitheatre Parkway, Mountain View, CA 94043'),
  ('Microsoft Corporation', 'microsoft.jpg', 'One Microsoft Way, Redmond, WA 98052'),
  ('Amazon.com, Inc.', 'amazon.jpg', '410 Terry Ave N, Seattle, WA 98109'),
  ('Meta Platforms, Inc.', 'meta.jpg', '1 Hacker Way, Menlo Park, CA 94025');
  
update company 
set image="https://dienbientv.vn/dataimages/202104/original/images3018033_inter_logo_moi_1617230158541716781437.png"
where name = "Apple Inc.";

update company 
set image="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d0/Logo_of_AC_Milan.svg/220px-Logo_of_AC_Milan.svg.png"
where name = "Google LLC";

update company 
set image="https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/Bologna_F.C._1909_logo.svg/640px-Bologna_F.C._1909_logo.svg.png"
where name = "Microsoft Corporation";

update company 
set image="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQhTZtdu0HRokX0CFXHGbpXa3YyDcgZChlUAg&s"
where name = "Amazon.com, Inc.";

update company 
set image="https://upload.wikimedia.org/wikipedia/vi/5/59/AtalantaBC.png"
where name = "Meta Platforms, Inc.";