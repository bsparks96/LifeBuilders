from sqlalchemy import Column, Integer, String
from utils.database import Base

class User(Base):
    __tablename__ = "Users"

    userID = Column(Integer, primary_key=True, index=True)
    username = Column(String(100), unique=True, nullable=False)
    firstName = Column(String(100))
    lastName = Column(String(100))
    userRole = Column(String(50))