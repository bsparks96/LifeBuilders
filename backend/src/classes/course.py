# classes/course.py
from pydantic import BaseModel

class CourseSummary(BaseModel):
    courseID: int
    courseName: str

    class Config:
        orm_mode = True