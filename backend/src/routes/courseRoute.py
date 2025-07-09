from fastapi import APIRouter, Depends
from sqlalchemy.orm import Session
from models.models import Course
from utils.database import get_db
from classes.course import CourseSummary

router = APIRouter()

@router.get("/courses/", response_model=list[CourseSummary])
def get_all_courses(db: Session = Depends(get_db)):
    return db.query(Course).all()